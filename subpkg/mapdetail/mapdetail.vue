<template>
	<view v-if="address.title" class="general">
		<view class="outbox">
			<!-- <image src="https://redmap.oss-cn-hangzhou.aliyuncs.com/bkgimg.jpg" class="background"></image> -->

			<view class="bkgBox">
				<view class="base-info">{{address.title}}</view>

				<!-- 轮播图的区域 -->
				<swiper :autoplay="true" :interval="3000" :duration="1000" :circular="true">
					<swiper-item v-for="(item, i) in address.img" :key="i">
						<view class="swiper-item">
							<image :src="item" mode="aspectFill"></image>
						</view>
					</swiper-item>
				</swiper>

				<view class="add-info">
					<uni-icons type="location-filled" size="24"></uni-icons>
					<view>地址：{{address.address}}</view>
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
				id: 0,
				address: {}
			};
		},
		onLoad(options) {
			this.id = options.id
			// console.log(this.id)
			// console.log(typeof this.id)
			this.getInfo();

		},
		methods: {
			async getInfo() {
				// console.log("id = " + this.id)
				const {
					data: res
				} = await uni.$http.get("https://redmap.ikarox.cn/place?id=" + this.id)
				// console.log(res)
				// console.log("?????")
				if (res.msg !== 'success') return uni.$showMsg()
				this.address = res.data
			}
		}
	}
</script>

<style lang="scss">
	.add-info {
		display: flex;
		align-items: center;
		font-size: 18px;
		/*垂直居中*/
		// justify-content: center;/*水平居中*/
	}

	.bkgBox {
		// margin: 20px 0;
		margin-top: 20px;
		margin-bottom: 20px;
		margin-left: 3%;
		margin-right: 3%;
		padding: 20rpx 20rpx;
		display: flex;
		flex-direction: column;
		border-radius: 10px;
		justify-content: center;
		background-color: #FFFFFF;
		border:3px dashed #e0e0e0;
		.base-info {
			text-align: center;
			font-size: 36rpx;
			font-weight: bold;
			margin-bottom: 5px;
			border-bottom: 1px solid #efefef;
			padding-bottom: 6px;
		}

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
	
	.outbox{
		// height: 830px;
		// margin-top: 40px;
		display: flex;
		align-items: center;
		justify-content: center;
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

	.background {
		width: 100%;
		height: 100%;
		position: fixed;
		background-size: 100% 100%;
		z-index: -1;
	}
</style>
