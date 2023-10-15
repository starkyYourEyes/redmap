<template>
	<view v-if="address.name" class="general">
		<!-- <image src="https://redmap.oss-cn-hangzhou.aliyuncs.com/bkgimg.jpg" class="background"></image> -->

		<view class="outbox">
			<view class="bkgBox">
				<view class="base-info" mode="scaleToFill">{{address.name}}</view>

				<!-- 轮播图的区域 -->
				<swiper :autoplay="true" :interval="3000" :duration="1000" :circular="true">
					<swiper-item v-for="(item, i) in address.imgs" :key="i">
						<view class="swiper-item">
							<image :src="item" mode="widthFix"></image>
						</view>
					</swiper-item>
				</swiper>

				<view class="add-info">
					<uni-icons type="location-filled" size="24"></uni-icons>
					<view>地址：{{address.address}}</view>
				</view>

				<view class="add-info">
					<uni-icons type="phone-filled" size="24"></uni-icons>
					<view>电话：{{address.tel}}</view>
				</view>

				<view class="add-info">
					<uni-icons type="info-filled" size="24"></uni-icons>
					<view>门票：{{address.ticket}}</view>
				</view>

				<view class="add-info" style="margin-bottom: 10px;">
					<uni-icons type="flag-filled" size="24"></uni-icons>
					<view>开放时间：{{address.ontime}}</view>
				</view>
				
				<scroll-view scroll-y class="intro">
					<view class="text"> {{address.intro}} </view>
				</scroll-view>

				<view>
					<video style="width: 100%;height=400px;margin:1px;" :src="address.video" controls></video>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				address: {},
			};
		},
		onLoad(options) {
			var id = options.id
			// console.log(this.id)
			// console.log(typeof this.id)
			this.getMemInfo(id);

		},

		methods: {
			async getMemInfo(id) {
				// console.log("id = " + this.id)
				const {
					data: res
				} = await uni.$http.get("https://redmap.ikarox.cn/mems?id=" + id)
				// console.log(res)
				// console.log("?????")
				// console.log(res)
				if (res.msg !== 'success') return uni.$showMsg()
				this.address = res.data
			}
		}
	}
</script>

<style lang="scss">
	.add-info {
		display: flex;
		width: 100%;
		font-size: 18px;
		// align-items:center;/*垂直居中*/
		// justify-content: center;/*水平居中*/
	}


	.ontime-info {
		// display: flex;
		// flex-wrap: wrap-reverse;
		border-bottom: 1px solid #efefef;
		margin-bottom: 10px;
		// align-items: center;
	}
	
	.outbox{
		// height: 890px;
		display: flex;
		align-items: center;
		justify-content: center;
	}

	.base-info {
		text-align: center;
		font-size: 36rpx;
		font-weight: bold;
		margin-bottom: 5px;
		border-bottom: 1px solid #efefef;
		padding-bottom: 6px;
	}

	.intro {
		border-bottom: 1px solid #efefef;
		margin-bottom: 10px;
		text-indent: 2em;
		height: 400rpx;
		// position: relative;
		background-image: url(../../static/intro-bkg.jpg);

		.text {
			padding-left: 12rpx;
			padding-top: 10rpx;
			padding-bottom: 15rpx;
			padding-right: 16rpx;
			font-size: 18px;
			z-index: 99;
		}
	}

	.bkgBox {
		// margin: 50px 0;
		margin-top: 20px;
		margin-bottom: 20px;
		margin-left: 3%;
		margin-right: 3%;
		padding: 20rpx 20rpx;
		display: flex;
		flex-direction: column;
		position: relative;
		border-radius: 10px;
		justify-content: center;
		background-color: #FFFFFF;
		border:3px dashed #e0e0e0
	}

	swiper {
		height: 360rpx;
		margin-top: 5px;
		// border-top: 1px solid #efefef;
		.swiper-item {
			display: flex;
			align-items: center;
			justify-content: center;
			background-position: center;
			height: 360rpx;
			
			image {
				// display: block;
				height: 360rpx;
				// width: 100%;
				// background-position: center;
				margin: auto;
				/*图片居中*/
			}
		}

		margin-bottom: 10px;
	}

	.general {
		background-image: url("https://redmap.oss-cn-hangzhou.aliyuncs.com/bkgimg.jpg");
		/* 背景图垂直、水平均居中 */
		background-position: center center;
		/* 背景图不平铺 */
		background-repeat: no-repeat;
		/* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
		background-attachment: fixed;
		/* 让背景图基于容器大小伸缩 */
		background-size: cover;
		/* 设置背景颜色，背景图加载过程中会显示背景色 */
		background-color: #464646;
	}

	.background {
		width: 100%;
		height: 100%;
		position: fixed;
		background-size: 100% 100%;
		z-index: -1;
	}
</style>
