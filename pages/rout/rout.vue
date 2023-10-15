<template>
	<view>
		<!-- 使用自定义的搜索组件 -->
		<image src="https://redmap.oss-cn-hangzhou.aliyuncs.com/bkgimg.jpg" class="background"></image>
		<view class="header">
			<my-search :bgcolor="'red'" @click="gotoSearch"></my-search>
			<view class="textinf">
				<text>“历史川流不息，精神代代相传。”</text>
				<text>红色资源是中华民族历史文明传承的重要载体，它所承载的历史，是中国近、现代史的核心内容，是中华文明史中最光彩照人的篇章，它记录着中国社会发生最深刻、最伟大变革的历史足迹。</text>
				<text>历百年而不老，一世纪正青春。前进的脚步从未停止，不朽的传奇还在继续。</text>
			</view>
		</view>
		<view class="footer" @click="clickImg">
			<image src="https://redmap.oss-cn-hangzhou.aliyuncs.com/%E6%89%8B%E7%BB%985.png" class="hand" mode="aspectFit"></image>
			 <!-- <text class="shouhui">手绘红色地图</text> -->
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				img: 'https://redmap.oss-cn-hangzhou.aliyuncs.com/%E8%BF%BD%E5%AF%BB.jpg'
			};
		},
		methods: {
			// 跳转到分包中的搜索页面
			gotoSearch() {
				uni.navigateTo({
					url: '/subpkg/search/search'
				})
			},
			clickImg() {
				// console.log("?")
				wx.previewImage({
					urls: [this.img], //需要预览的图片http链接列表，多张的时候，url直接写在后面就行了
					current: this.img, // 当前显示图片的http链接，默认是第一个
					success: function(res) {},
					fail: function(res) {},
					complete: function(res) {},
				})
			}
		}
	}
</script>

<style lang="scss">
	.textinf {
		margin-top: 36px;
		display: flex;
		flex-direction: column;
		text-indent: 2em;
		font-size: 19px;
		font-weight: bolder;

		// align-items: center;
		// /*垂直居中*/
		// justify-content: center;

		// /*水平居中*/
		// image {
		// 	border-radius: 24px;

		// 	height: 240rpx;
		// 	width: 480rpx;
		// }

		// margin-bottom: 20px;

	}

	.header {
		// padding-bottom: 240px;
		height: calc(100vh - 142.5px);
	}

	.footer {
		// position: relative;
		display: flex;
		justify-content: center;
		align-items: center;
		// margin-top: -240px;
	}

	.shouhui{
		text-align: center;
	}
	
	.background {
		width: 100%;
		height: 100%;
		position: fixed;
		background-size: 100% 100%;
		z-index: -1;
	}
</style>
