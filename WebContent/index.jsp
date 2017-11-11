<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts2-ajax Test</title>
<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/iconfont.css">
<link rel="stylesheet" href="font/stylesheet.css" type="text/css"
	charset="utf-8" />
<style>
html, body {
	width: 100%;
	height: 100%;
	margin: 0;
	/* background-image: url("./images/preview.jpg"); */
	background-size: 70%;
}

body {
	display: flex;
	flex-direction: column;
}

#topPanel {
	flex-grow: 1;
	min-height: 60px;
	max-height: 60px;
	background-color: #4589ae;
}

#bottomPanel {
	flex-grow: 1;
	display: flex;
	flex-direction: row;
}

#bottomPanel .menu-panel {
	flex-grow: 1;
	min-width: 200px;
	max-width: 200px;
	background-color: #649fd1;
}

#bottomPanel .content-panel {
	flex-grow: 1;
	/*  background-color: blue; */
}

#topPanel .logo-panel {
	width: 450px;
	height: 60px;
	float: left;
	margin-left: 20px;
}

#topPanel .menu-panel {
	width: 300px;
	height: 100px;
	float: right;
}

#bottomPanel .menu-panel .avatar-panel {
	width: 200px;
	height: 230px;
	position: absolute;
	bottom: 10px;
}

#topPanel .logo-panel .logo-content-panel {
	width: 75px;
	height: 60px;
	float: left;
	background-image: url("./images/logo.jpg");
	/* margin-top: 8px; */
	background-size: cover;
}

#topPanel .logo-panel-byte {
	width: 350px;
	height: 30px;
	font-size: 65px;
	color: white;
	/*text-align: top;*/
	margin-left: 200px;
	margin-top: -25px;
	font-family: 'chocolate_dealerbold';
	display: flex;
	flex-direction: column;
}

#topPanel .menu-panel ul {
	list-style: none;
	float: right;
	margin: 0;
}

#topPanel .menu-panel ul li {
	float: left;
	font-size: 15px;
	padding-right: 50px;
	line-height: 60px;
}

#topPanel .menu-panel ul li a {
	text-decoration: none;
	color: white;
}

#topPanel .menu-panel ul li a:hover {
	color: #4d98c1;
}

#topPanel .menu-panel ul li a:active {
	color: white;
}

#bottomPanel .menu-panel .avatar-panel .avatar-content-panel {
	width: 140px;
	height: 140px;
	padding: 30px;
}

#bottomPanel .menu-panel .avatar-panel .avatar-content-panel>div {
	width: 100%;
	height: 100%;
	background-image: url("./images/login.jpg");
	background-size: contain;
	border-radius: 50%;
	border: 2px solid white;
	background-size: contain;
}
@-webkit-keyframes rotation{
from {-webkit-transform: rotate(0deg);}
to {-webkit-transform: rotate(360deg);}
}
#bottomPanel .menu-panel .avatar-panel .avatar-content-panel .transfar{
-webkit-transform: rotate(360deg);
animation: rotation 3s linear infinite;
-moz-animation: rotation 3s linear infinite;
-webkit-animation: rotation 3s linear infinite;
-o-animation: rotation 3s linear infinite;
}


#bottomPanel .menu-panel .avatar-panel .avatar-text-panel {
	width: 200px;
	height: 30px;
	text-align: center;
	line-height: 30px;
}

#bottomPanel .menu-panel .nav {
	list-style: none;
	padding: 0;
	margin: 0;
}

#bottomPanel .menu-panel .nav li {
	height: 40px;
	line-height: 40px;
	text-align: center;
	border-bottom: 1px solid #ccc;
	font-size: 20px;
	cursor: pointer
}

#bottomPanel .menu-panel .nav li {
	text-decoration: none;
}

#bottomPanel .menu-panel ul li:hover {
	color: #e0e0e0;
}

#bottomPanel .menu-panel ul li.change {
	color: white;
}

#content-btn-panel button {
	margin: 15px;
	width: 90px;
	height: 30px;
	border: none;
	width: 90px;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
	text-align: center;
}

table thead {
	border-bottom: 2px solid gray;
}

table th {
	height: 50px;
	width: 140px;
}

table tr td {
	height: 50px;
	width: 140px;
	line-height: 40px;
}

button:hover {
	filter: grayscale(0.4);
}

#topPanel .sys {
	height: 30px;
	font-size: 20px;
	margin-top: 24px;
	text-align: center;
	color: white;
	font-family: '楷体';
}
</style>
</head>
<body>
	<div id="topPanel">
		<div class="logo-panel">
			<div class="logo-content-panel"></div>
			<!--  <h5>用户管理系统</h5> -->
			<div class="logo-panel-byte">Norman</div>
			<div class="sys">管理系统</div>
		</div>
		<div class="menu-panel">
			<ul>
				<li><a href="https://www.baidu.com/">帮助</a></li>
				<li><a href="exit.action">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="bottomPanel">
		<div class="menu-panel">
			<div class="menu-content-panel">
				<ul class="nav">
					<li class="user"><i class="icon iconfont icon-icon"></i>账号管理</li>
					<li class="role"><i class="icon iconfont icon-jiaose"></i>角色管理</li>
					<li class="juri"><i class="icon iconfont icon-quanxian"></i>权限管理</li>
					<li class="dep"><i class="icon iconfont icon-bumen"></i>部门管理</li>
				</ul>
			</div>
			<div class="avatar-panel">
				<div class="avatar-content-panel">
					<div class="transfar">${message }</div>
				</div>
				<div class="avatar-text-panel">当前登录用户</div>
			</div>
		</div>
		<div class="content-panel">
			<div id="content-btn-panel"></div>
			<div class="content-table-panel"></div>
		</div>
	</div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-2.1.3.js"></script>
	<script>
		var $goodsPanel;
		var $goodsCategoryPanel;
		var $goodsContentPanel;

		$(function() {
			$goodsContentPanel = $(".content-table-panel");
			$goodsCategoryPanel = $("content-panel");
			// 用户
			$(".user").on("click", function() {
				$goodsContentPanel.load("user")
			}).first().click();
			// 权限
			$(".juri").on("click", function() {
				$goodsContentPanel.load("juri");
			});
			// 部门
			$(".dep").on("click", function() {
				$goodsContentPanel.load("dep");
			});
			// 角色
			$(".role").on("click", function() {
				$goodsContentPanel.load("role");
			});
			$("#bottomPanel .menu-panel ul li").click(
					function() {
						$("#bottomPanel .menu-panel ul li").eq($(this).index())
								.addClass("change").siblings().removeClass(
										"change");
					})
		});
	</script>
</body>
</html>