<template>
	<view>
		<view class="map-body">
			<view class="page-section page-section-gap">
				<map :latitude="latitude" :longitude="longitude" :markers="markers" include-points @markertap="markClickHandler"
				 scale="4" joinCluster>
				</map>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				key: 'PWKBZ-64BKI-WDBGX-UPS5D-3KXXE-Y5F7K',
				city: '河南省南阳市卧龙区312国道口北侧',
				latitude: 0,
				longitude: 0,

				cover: {
					id: 0,
					width: 15,
					height: 15,
					iconPath: '../../static/loc.png',
					latitude: 0,
					longitude: 0,
					callout: {
						content: '',
						display: 'ALWAYS',
						fontSize: 12,
						borderColor: '#FF0000',
						borderRadius: 16,
						borderWidth: 3,
						padding: 2,
						textAlign: 'center'
					}
				},

				// 后端获取
				markers: [],
				locs: []


			};
		},
		onLoad() {
			wx.request({
				url: 'https://apis.map.qq.com/ws/geocoder/v1/?address=' + this.city + '&key=' + this.key,
				success: res => {
					this.latitude = res.data.result.location.lat
					this.longitude = res.data.result.location.lng
					// console.log(this.latitude + '' + this.longitude)
				}
			})
			
			this.getMarkers();

		},
		methods: {
			markClickHandler(e) {
				uni.navigateTo({
					url: '/subpkg/mapdetail/mapdetail?id=' + e.detail.markerId
				})
			},
			async getMarkers() {
				const {
					data: res
				} = await uni.$http.get("https://redmap.ikarox.cn/marker")
				
				this.locs = res.data
				// this.markers = res.data

				for (var i = 0; i < this.locs.length; i++) {
					this.cover.id = this.locs[i].id;
					// console.log("id = " + this.locs.id)
					this.cover.latitude = this.locs[i].latitude
					this.cover.longitude = this.locs[i].longitude
					this.cover.callout.content = this.locs[i].content
					// console.log(this.cover)
					this.locs[i] = JSON.parse(JSON.stringify(this.cover))
				}
				this.markers = this.locs
				
			}
		}
	}
</script>

<style lang="scss">
	map {
		width: 100%;
		height: 100vh
	}
</style>
