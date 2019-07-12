<%@page import="com.newlecture.web.dao.file.FileNoticeDao"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" style="font-size: 10px">
<!-- web-inf 디렉토리에 넣으면 사용자가 view를 바로 호출할 수 없다 -->
<head>
<link rel="shortcut icon" href="">
<meta charset="UTF-8">
<title>Document</title>

<link href="/css/style.css" type="text/css" rel="stylesheet">

</head>

<body>
	<!-- --- header block----------------------------------------------------------------------------------->
	<jsp:include page="../../inc/header.jsp"></jsp:include>
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
	<div id="body">
		<div class="content-box">

			<jsp:include page="../../inc/aside.jsp"></jsp:include>

			<main>

			<section>
				<h1>공지사항</h1>
				
				<section id="breadcrumb">
					<h1 class="d-none">경로</h1>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</section>

				<section>
					<form action="reg" method="post" enctype="multipart/form-data">
					<!-- <form action="reg" method="post" enctype="application/x-www-form-urlencoded"> -->
					// key와 값이 함께 키가 곧 값이되고 값이 곧 키가되는 방식으로 전달되는 것
						<h1>공지사항 내용</h1>
						<table>
							<tbody>
								<tr>		
									<th>카테고리</th>
									<td>
									<select name="category">
									<option value ="학습">학습</option>
									<option value ="결제">결제</option>
									<option value ="기타">기타</option>
									</select>
									</td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input name="title"></td>
								</tr>
								<tr>
								<th>첨부파일</th>
								<td><input type="file" name="file"></td>
								</tr>
								<tr>
									<th>내용</th>
									<td><textarea name="content"></textarea></td>
								</tr>
				
				
				
							</tbody>
						</table>

						<div>
							<input type="submit" value="저장"> <a href="list">취소</a>
						</div>


					</form>
				</section>
			</main>
			<!-- <div style="clear:left;">막내</div> -->
		</div>
	</div>

	<!-- --- footer block----------------------------------------------------------------------------------->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>

</html>