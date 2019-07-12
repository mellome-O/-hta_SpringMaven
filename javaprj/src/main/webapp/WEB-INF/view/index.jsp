
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Document</title>
<link rel="shortcut icon" href="">
<link href="../css/style.css" type="text/css" rel="stylesheet">
<style>
#footer {
	width: 375px;
}
</style>

</head>

<body>
	<!-- --- header block----------------------------------------------------------------------------------->
	<header id="header">
		<div>
			<a href="" class="icon icon-menu">펼침버튼</a>
		</div>
		<!-- <h1><a href="" ><img src="" alt="뉴렉처 온라인"></a></h1> -->
		<h1><a href="" id="logo">뉴렉처 온라인</a></h1>
		<div>
			<a href="" class="icon icon-search">검색버튼</a>
		</div>
	</header>
	<section id="visual">
	
	</section>
	<main>
		<section id="top-lecture">
		${x}
		</section>
		<section id="lecture">
		</section>
		<section id="notice">
		</section>
	</main>
	<!-- --- visual block----------------------------------------------------------------------------------->
	<div id="visual">
		<div class="content-box" style="position: static">

			<!-- <div style="
            width:100px; height:100px; border:1px solid red;
        background: url(https://i.uncyclopedia.kr/pedia/7/7c/%EC%9E%91%EC%9D%80%ED%95%98%EB%A7%883.png);
        background-size: cover;
        background-attachment:fixed;">
        <span style="left:1000px; top:1000px; position:absolute;">왜저랩사진</span>
      <img src="https://i.uncyclopedia.kr/pedia/7/7c/%EC%9E%91%EC%9D%80%ED%95%98%EB%A7%883.png"> -->
			<!-- <span style="margin-left:-50px">웅이왜저랩사진</span> -->
			<!-- <img src="http://cdn.sketchpan.com/member/m/mssng486/mandala/1332657085387/0.png"> -->
			<!-- </div> -->
		</div>
	</div>
	<!-- --- body block----------------------------------------------------------------------------------->
	
	<!-- --- footer block----------------------------------------------------------------------------------->
	<jsp:include page="inc/footer.jsp"></jsp:include>

</body>

</html>