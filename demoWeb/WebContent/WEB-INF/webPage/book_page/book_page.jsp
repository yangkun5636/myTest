<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>book_page</title>
<link type="text/css" href="${ctx }/css/book_page/css/main.css" rel="stylesheet" media="screen" />	
</head>
<body>

<div id="shineflip">
	<div id="shineflip-pages">
		<canvas id="shineflip-canvas"></canvas>
		<canvas id="shineflip-page-mid-canvas"></canvas>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/0.jpg" width="475" height="482" /></div>
			<span style="left:18px;"><img src="${ctx }/images/book_page/images/zh.png" height="482" /></span> 
		</section>
		<section class="page" style="background:url(${ctx }/images/book_page/images/left_pk.jpg)">
			<div><img src="${ctx }/images/book_page/images/1.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/2.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/3.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/4.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/5.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page" style="background:url(${ctx }/images/book_page/images/right_pk.jpg)">
			<div><img src="${ctx }/images/book_page/images/6.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page" style="background:url(${ctx }/images/book_page/images/left_pk.jpg)">
			<div><img src="${ctx }/images/book_page/images/1.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/2.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/3.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/4.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/5.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page" style="background:url(${ctx }/images/book_page/images/right_pk.jpg)">
			<div><img src="${ctx }/images/book_page/images/6.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page" style="background:url(${ctx }/images/book_page/images/left_pk.jpg)">
			<div><img src="${ctx }/images/book_page/images/1.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/2.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/3.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/4.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/5.jpg" width="466" height="463" style="float:right;margin-top:9px;" /></div>
		</section>
		<section class="page" style="background:url(${ctx }/images/book_page/images/right_pk.jpg)">
			<div><img src="${ctx }/images/book_page/images/6.jpg" width="466" height="463" style="float:left;margin-top:9px;" /></div>
		</section>
		<section class="page">
			<div><img src="${ctx }/images/book_page/images/24.jpg" width="475" height="482" /></div>
			<span style="right:18px;"><img src="${ctx }/images/book_page/images/zh.png" height="482" /></span> 
		</section>
	</div>
</div>

<script type="text/javascript" src="${ctx }/js/book_page/js/shineflip_min.js"></script>
<script type="text/javascript">
var shineFlip = new ShineFlip({
	// autoFitScreen: true,
	width: 950,
	height: 482,
	page_width: 475,
	page_height: 482
});
</script>

</body>
</html>