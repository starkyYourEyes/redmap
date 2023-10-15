<template>
	<view>
		<!-- 定义navi导航方法 -->
		<!-- <view @click="navi">
			<image src="http://m.qpic.cn/psc?/V12iywoj0vjy8D/qWkkGOdvaHRbO0s2SzmJ0A6hNpVJHy5e8X9YJE5pp4uwGevHzWWheEAT7sJz7cZvbW8hMNK3SKrz4ZQ4Is.w5w!!/b&bo=IAAgAAAAAAADByI!&rf=viewer_4&t=5"></image>
			<view>
				<text>导航</text>
			</view>
		</view> -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
				key: 'PWKBZ-64BKI-WDBGX-UPS5D-3KXXE-Y5F7K',
				loc: '',
				locname: '',
				latitude: 0,
				longitude: 0
			};
		},
		onLoad(options) {
			this.loc = options.loc
			this.locname = options.name

			wx.request({
				url: 'https://apis.map.qq.com/ws/geocoder/v1/?address=' + this.loc + '&key=' + this.key,
				success: res => {
					this.latitude = res.data.result.location.lat;
					this.longitude = res.data.result.location.lng;
					// console.log(this.latitude + '' + this.longitude)

					wx.openLocation({
						latitude: this.latitude, //维度
						longitude: this.longitude, //经度
						name: this.locname, //目的地定位名称
						scale: 15, //缩放比例
						address: this.loc //导航详细地址
					});

				}
			})
		}
	}
</script>

<style lang="scss">

</style>
