<template>
	<view class="general">
		<view>
			<!-- <text></text> -->
			<view class="memBox">
				<!-- <image src="https://redmap.oss-cn-hangzhou.aliyuncs.com/bkgimg.jpg" class="background"></image> -->
				<view class="index-container" v-for="(item, i) in bkgImgs" :key="i">
					<navigator class="imgsOfMem" :url="'/subpkg/mems/mems?id=' + i">
						<text class="infoTxt">{{item.name}}</text>
						<image :src="item.img"></image>
					</navigator>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				bkgImgs: []
			};
		},
		onLoad() {
			this.getBkgImg()
		},
		methods: {
			async getBkgImg() {
				const {
					data: res
				} = await uni.$http.get("https://redmap.ikarox.cn/memBkgImg");
				this.bkgImgs = res.data
			}
		}
	}
</script>

<style lang="scss">
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


	.index-container {
		// margin-top: 20px;
		// display: flex;
		text-align: center;
		font-size: 36rpx;
		font-weight: bold;
		// flex-direction: column;
		// align-items: center;
		align-items: center;
		/*垂直居中*/
		justify-content: center;
		/*水平居中*/
		// color: black;
		
		.imgsOfMem {
			display: flex;
			flex-direction: column;

			align-items: center;
			/*垂直居中*/
			justify-content: center;

			/*水平居中*/
			image {
				border-radius: 24px;

				height: 240rpx;
				width: 480rpx;
			}

			margin-bottom: 20px;
		}

	}

	.memBox {
		padding-top: 12px;
		padding-bottom: 8px;
	}

	.background {
		width: 100%;
		height: 100%;
		position: fixed;
		background-size: 100% 100%;
		z-index: -1;
	}
</style>
