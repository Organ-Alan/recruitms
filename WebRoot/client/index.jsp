<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<!-- Basic Page Needs
  ================================================== -->
<meta>
<title>广州大学华软软件学院招生网</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
  ================================================== -->
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/settings.css"
	media="screen" />


<!-- JS
  ================================================== -->
<script src="../js/jquery-1.8.2.min.js" type="text/javascript"></script>
<!-- jQuery -->
<script src="../js/jquery.easing.1.3.js" type="text/javascript"></script>
<!-- jQuery easing -->
<script src="../js/modernizr.custom.js" type="text/javascript"></script>

<!-- Modernizr -->
<script src="../js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<!-- tabs, toggles, accordion -->
<script src="../js/custom.js" type="text/javascript"></script>
<!-- jQuery initialization -->

<!-- Responsive Menu -->
<script src="../js/jquery.meanmenu.js"></script>
<script>
	jQuery(document).ready(function() {
		jQuery('header nav').meanmenu();
	});
</script>

<!-- Revolution Slider -->
<script src="../js/jquery.themepunch.plugins.min.js"></script>
<script src="../js/jquery.themepunch.revolution.min.js"></script>
<script src="../js/revolution-slider-options.js"></script>

<!-- Prety photo -->
<script src="../js/jquery.prettyPhoto.js"></script>
<script>
	$(document).ready(function() {
		$("a[data-gal^='prettyPhoto']").prettyPhoto();
	});
</script>

<!-- Tooltip -->
<script src="../js/tooltip.js"></script>

<!-- Flexisel -->
<script type="text/javascript" src="../js/jquery.flexisel.js"></script>

<!-- Favicons
	================================================== -->
<link rel="shortcut icon" href="../images/title-logo.jpg">
<link rel="apple-touch-icon" href="../images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="../images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="../images/apple-touch-icon-114x114.png">

</head>
<body>



	<!-- Primary Page Layout
	================================================== -->

	<header class="header">

	<div class="container">
		<div class="logos columns">
			<h1 class="logo">
				<a href="index.jsp"><img src="../images/logo/logo-v2.png"
					alt="Campus Logo" /></a>
			</h1>
		</div>
		<!-- logo -->

		<div class="twelve columns">
			<nav class="main_menu">

			<ul>
				<li class="current_page_item"><a href="index.jsp">
						首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页
						<div class="sub">Get Started</div>
				</a></li>

				<li><a href="about-us.html"> &nbsp;&nbsp;&nbsp;华软宣传
						<div class="sub">My Campus</div>
				</a>
					<ul>
						<li><a href="about-us.html">华软简介</a></li>
						<li><a href="about-us-2.html">美丽华软</a></li>
						<li><a href="about-me.html">学院内网</a></li>
						<li><a href="services.html">社团组织</a></li>
					</ul></li>

				<li><a href="#"> 招生主题
						<div class="sub">Recruit</div>
				</a>
					<ul>
						<li><a href="tabs.html">招生计划</a></li>
						<li><a href="buttons.html">招生须知</a></li>
						<li><a href="dropcaps.html">往年分数线</a></li>
					</ul></li>

				<li><a href="portfolio-2-columns.html"> 新生指南
						<div class="sub">Guidance</div>
				</a>
					<ul>
						<li><a href="portfolio-1-column.html">热点问题</a></li>
						<li><a href="portfolio-2-columns.html">新生入学须知</a></li>
						<li><a href="portfolio-3-columns.html">录取通知书</a></li>
						<li><a href="blog-large.html">办学特色</a></li>
					</ul></li>

				<li><a href="blog-large.html"> 人才培养
						<div class="sub">Talents</div>
				</a>
					<ul>
						<li><a href="blog-large.html">办学特色</a></li>
						<li><a href="blog-medium.html">就业网</a></li>

					</ul></li>

				<li><a href="contact.html"> 联系我们
						<div class="sub">Contact US</div>
				</a></li>
			</ul>

			</nav>
			<!-- navigation -->
		</div>
		<div class="clearfix"></div>
	</div>
	</header>
	<!-- header -->


	<!-- REVOLUTION SLIDER
	============================================= -->
	<div class="fullwidthbanner-container top-shadow">
		<div class="fullwidthbanner">
			<ul>
				<!-- Slide 1 -->
				<li data-transition="boxfade" data-slotamount="2"
					data-masterspeed="300">
					<!-- Main Image --> <img src="../images/slider/sliderone.jpg" alt="">
					<!-- End Main Image -->
				</li>
				<!-- End Slide 1 -->
				<!-- Slide 2 -->
				<li data-transition="boxfade" data-slotamount="3"
					data-masterspeed="300">
					<!-- Main Image --> <img src="../images/slider/slidertwo.jpg" alt="">
					<!-- End Main Image -->
				</li>
				<!-- End Slide 2 -->
				<!-- Slide 3 -->
				<li data-transition="boxfade" data-slotamount="4"
					data-masterspeed="300">
					<!-- Main Image --> <img src="../images/slider/sliderthree.jpg" alt="">
					<!-- End Main Image -->
				</li>
				<!-- End Slide 3 -->
				<!-- Slide 4 -->
				<li data-transition="boxfade" data-slotamount="5"
					data-masterspeed="300">
					<!-- Main Image --> <img src="../images/slider/sliderfour.jpg" alt="">
					<!-- End Main Image -->
				</li>
				<!-- End Slide 4-->
			</ul>
		</div>
	</div>
	<!-- END REVOLUTION SLIDER
	============================================= -->
	<div class="container">

		<div class="sixteen columns welcome">
			<h3>博学笃行 &amp; 与时俱进</h3>
		</div>
			<div class="one-third column">
				<!-- Icon Box -->
				<div class="icon-box medium">
					<i class="fa fa-css3 medium colored"></i>
					<h4>
						<a href="#" class="dark-link">招生计划</a>
					</h4>
					<p>十大专业本年度招生计划。包含各省份招生人数，以及国际班招生计划</p>
				</div>
				<!-- End Icon Box -->
			</div>
			<div class="one-third column">
				<!-- Icon Box -->
				<div class="icon-box medium">
					<i class="fa fa-magic medium colored"></i>
					<h4>
						<a href="#" class="dark-link">招生章程</a>
					</h4>
					<p>广州大学华软软件学院2018年普通高校招生章程</p>
				</div>
				<!-- End Icon Box -->
			</div>
			<div class="one-third column">
				<!-- Icon Box -->
				<div class="icon-box medium">
					<i class="fa fa-bullhorn medium colored"></i>
					<h4>
						<a href="#" class="dark-link">入学须知</a>
					</h4>
					<p>每一个新的地方都有着新的人情世故</p>
				</div>
				<!-- End Icon Box -->
			</div>

			<div class="clearfix"></div>
			<div class="separator"></div>

			<div class="sixteen columns">
				<h4 class="headline">招生宣传</h4>
			</div>

			<div class="four columns identity photography tehnology">
					<div class="work">
						<a href="#" class="work-image">
							<img src="../images/portfolio/smiling.jpg" alt="">
							<div class="link-overlay fa fa-search"></div>
						</a>
						<a href="#" class="work-name">Smiling</a>
						<div class="tags">
							 Photography, Tehnology
						</div>
					</div>
				</div>
				<div class="four columns photography webdesign">
					<div class="work">
						<a href="../images/portfolio/couple-big.jpg" data-gal="prettyPhoto" class="work-image">
							<img src="../images/portfolio/couple.jpg" alt="">
							<div class="link-overlay fa fa-search"></div>
						</a>
						<a href="#" class="work-name">Couple</a>
						<div class="tags">
							 Photography, Webdesign
						</div>
					</div>
				</div>
				<div class="four columns identity">
					<div class="work">
						<a href="../../vimeo.com/67500403" data-gal="prettyPhoto" class="work-image">
							<img src="../images/portfolio/beach.jpg" alt="">
							<div class="link-overlay fa fa-play"></div>
						</a>
						<a href="#" class="work-name">Beach</a>
						<div class="tags">
							 Identity
						</div>
					</div>
				</div>
				<div class="four columns identity">
					<div class="work">
						<a href="../images/portfolio/surfing-big.jpg" data-gal="prettyPhoto" class="work-image">
							<img src="../images/portfolio/surfing.jpg" alt="">
							<div class="link-overlay fa fa-search"></div>
						</a>
						<a href="#" class="work-name">Surfer</a>
						<div class="tags">
							 Identity
						</div>
					</div>
				</div>

			<div class="clearfix"></div>

			<div class="separator"></div>

			<div class="eight columns">
				<h3 class="headline">为什么选择我们？</h3>
				<ul class="list iconok circle">
					<li>Asunt in anim uis aute irure dolor in reprehenderit</li>
					<li>Excepteur sint occaecat cupidatat non proident, sunt in
						anim</li>
					<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit</li>
					<li>Irure dolor in reprehenderit in voluptate velit esse
						cillum</li>
					<li>Tempora incidunt, ut labore et dolore occaecat cupidatat
						non proident</li>
				</ul>

			</div>

			<div class="eight columns">
				<h3 class="headline">领导讲话</h3>

				<!-- Testimonial -->
				<blockquote class="speech-bubble">
					<div class="quote-content">
						<p>Maecenas lacus aliquet et nisl nunc, per sed sed
							maecenas.Lectus tincidunt pellentesque augue urna sit sed, arcu
							sed ante ac montes.</p>
						<span class="quote-arrow"></span>
					</div>
					<div class="quote-meta">
						John Doe, Developer<br> <span class="grey-text">Company</span>
					</div>
				</blockquote>
				<!-- End Testimonial -->

			</div>

			<div class="clearfix"></div>

		</div>
		<!-- container -->

		<footer class="footer">
		<div class="container">
			<div class="footer-top clearfix">
				<div class="four columns">
					<h3>关于我们</h3>
					<p>欢迎报考广州大学华软软件学院</p>
					<p>Welcome to South Institude Of Software Engineering.GU.</p>
				</div>
				<div class="four columns">
					<h3>友情链接</h3>
					<div class="twitter">
						<ul>
							<!-- Link Message 1 -->
							<li><span>华软就业网<a href="#" class="link">http://gzdxhrrjxy.bibibi.net/</a>
							</span> 
							<!-- Link Message 2 -->
							<li><span>广州招考网 <a href="#" class="link">http://www.gzzk.cn/zbjs/</a>
							</span> 
							<!-- Link Message 3 -->
							<li><span>华软官网 <a href="#" class="link">http://www.sise.com.cn/</a>
							</span>
						</ul>
					</div>
				</div>
				<div class="four columns">
					<h3>美丽华软</h3>
					<div class="latest-project">
						<div class="latest-project-item">
							<a href="#"><img src="../images/elements/footer-1.jpg" alt=""></a>
						</div>
						<div class="latest-project-item">
							<a href="#"><img src="../images/elements/footer-2.jpg" alt=""></a>
						</div>
						<div class="latest-project-item">
							<a href="#"><img src="../images/elements/footer-3.jpg" alt=""></a>
						</div>
						<div class="latest-project-item">
							<a href="#"><img src="../images/elements/footer-4.jpg" alt=""></a>
						</div>
						<div class="latest-project-item">
							<a href="#"><img src="../images/elements/footer-5.jpg" alt=""></a>
						</div>
						<div class="latest-project-item">
							<a href="#"><img src="../images/elements/footer-6.jpg" alt=""></a>
						</div>
					</div>
				</div>
				<div class="four columns">
					<h3>联系 我们</h3>
					<ul class="list contact" style="margin-bottom: 15px;">
						<li class="contact-address"><i class="fa fa-map-marker"></i><span>510990.
								广东省广州市从化区经济开发区高技术产业园广从南路548号</span></li>
						<li class="contact-mail"><i class="fa fa-envelope"></i><a
							class="link" href="#">enroll@sise.com.cn</a></li>
						<li class="contact-phone"><i class="fa fa-phone"></i><span>020-87818781，020-87818808</span></li>
						<li class="contact-address"><i class="fa fa-clock-o"></i><span>Monday-Friday:
								9:<sup>00</sup> - 18:<sup>00</sup><br> Saturday: 10:<sup>00</sup>
								- 17:<sup>00</sup><br> Sunday: closed
						</span></li>
					</ul>

				</div>
			</div>
			<!-- footer-top -->
		</div>

		<div class="container">
			<div class="footer-bottom clearfix">
				<div class="eight columns">
					<p>
						Copyright &copy; 2018 <a href="#">hgl Alan
					</p>
				</div>
				<div class="eight columns">
					<nav class="footer-nav">
					<ul>
						<li><a class="first" href="index.jsp">首页</a>/</li>
						<li><a href="#">华软宣传</a>/</li>
						<li><a href="#">招生主题</a>/</li>
						<li><a href="#">新生指南</a>/</li>
						<li><a href="#">联系我们</a></li>
					</ul>
					</nav>
				</div>
			</div>
			<!-- footer-bottom -->
		</div>

		</footer>
		<!-- footer -->
<script type="text/javascript">

$(window).load(function() {
	$("#flexiselDemo2").flexisel({
		visibleItems: 5,
		animationSpeed: 1000,
		autoPlay: true,
		autoPlaySpeed: 3000,    		
		pauseOnHover: true,
		enableResponsiveBreakpoints: true,
    	responsiveBreakpoints: { 
    		portrait: { 
    			changePoint:480,
    			visibleItems: 1
    		}, 
    		landscape: { 
    			changePoint:640,
    			visibleItems: 2
    		},
    		tablet: { 
    			changePoint:768,
    			visibleItems: 3
    		}
    	}
    });
    
});
</script>
		<!-- End Document
================================================== -->
</body>
</html>