
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


<script src="../../js/notice/list.js"></script>
</head>

<body>
	<!-- --- header block----------------------------------------------------------------------------------->
	<jsp:include page="../inc/header.jsp"></jsp:include>
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

			<jsp:include page="../inc/aside.jsp"></jsp:include>



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

				<section id="notice">
					<h1 class="d-none">공지사항목록</h1>
					
					<!-- form 기본은 get으로 되어있음
					post로 변경 -->
<template class = "notice-template" >
	<tr>
	<td class="num"></td>
	<td class="title"><a href="detail?id="></a>
			
	<span></span>
	<span><a href="list?eid=">수정</a><a href="">삭제</a></span>
	</td>
	<td class="writer"></td>
	<td class="date"></td>
	<td class="hit"></td>
	</tr>
</template>
						<table>
							<thead>
								<tr>
									<td class="num">번호</td>
									<td class="title">제목</td>
									<td class="writer">작성자</td>
									<td class="date">작성일</td>
									<td class="hit">조회수</td>
								</tr>
							</thead>
							<tbody>
						<!-- varStatus의 속성들 -->
					
							<c:forEach var="n" items="${noticelist}" begin="0" end="9" varStatus="s"> 
										<c:if test ="${s.index %2==0}">
										<tr class="even">
										<td class="num">${n.id}</td>
											<td class="title"><a href="detail?id=${n.id}">
													${s.index}/${s.current.title} :  ${n.title} </a> <span>[23]</span>
											</td>
											<td class="writer">${n.writerId}</td>
											<td class="date">${n.regDate}</td>
											<td class="hit">${n.hit}</td>
											</tr>
										</c:if>
										<c:if test ="${s.index %2==1}">
										<tr>
											<td class="num">${n.id}</td>
											<td class="title"><a href="detail?id=${n.id}">
													${s.index}/${s.current.title} :  ${n.title} </a> <span>[23]</span>
											</td>
											<td class="writer">${n.writerId}</td>
											<td class="date">${n.regDate}</td>
											<td class="hit">${n.hit}</td>
										</tr>
										</c:if>
								</c:forEach>
						
								<tr>
									<td colspan = "5">-----------------------------------------</td>
								</tr>

								<!--     <tr>
                                    <td class="num">2</td>
                                    <td class="title">유투브에 jQuery와 Angular 프레임워크 1강이 등록되었습니다.</td>
                                    <td class="writer">newlec</td>
                                    <td class="date">2019-02-18</td>
                                    <td class="hit">177</td>
                                </tr>

                                <tr>
                                    <td class="num">1</td>
                                    <td class="title">앞으로 모든 강의를 무료로 새로 시작합니다.</td>
                                    <td class="writer">newlec</td>
                                    <td class="date">2018-11-18</td>
                                    <td class="hit">767</td>
                                </tr> -->
							</tbody>
						</table>
					</form>
					<div>
						<a href="reg">글쓰기</a>
					</div>
				</section>



				<section id="page-index">
					<h1 class="d-none">페이지정보</h1>
					<div>
						<span class="color-highlight font-bold">1</span> / 1 pages
					</div>
				</section>
				
				<div id="text-remove">
					<label>삭제할 게시글ID</label><input type="text" value="">
					<input type="button" value="삭제">
				
				<div id="text-pager">
					<input type="text">
					<input type="button" value="요청">
				</div>
				<!--  (진리값 혹은 진리값오게하는계산식) ? 참일경우 : 거짓일경우 -->
				<c:set var="page" value="${ (empty param.p) ? 1 : param.p}"/>
				<c:set var="start" value="${page-(page-1)%5}"/>
				<c:set var="end" value=""/>
				
				<section id="pager">
					<h1 class="d-none">페이지</h1>
					<div>
						<div>이전</div>
		
						<ul>
							<c:forEach var="n" begin="${start}" end="${start+4}" varStatus="s">
							<%-- items="${list}" 
							<li class="current"><a href="list?p=${s.count}">${s.count}</a></li> --%>
							<li class="current"><a href="list?p=${n}">${n}</a></li>
							</c:forEach>
						</ul>
						
						<div>다음</div>
					</div>
				</section>
			</main>
			<!-- <div style="clear:left;">막내</div> -->
		</div>
	</div>

	<!-- --- footer block----------------------------------------------------------------------------------->
	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>

</html>
