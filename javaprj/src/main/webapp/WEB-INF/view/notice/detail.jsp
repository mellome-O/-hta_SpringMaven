<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Document</title>
<!-- 사용자가 직접 jsp를 요청하면 안되는 이유? mvc는 컨트롤러와 뷰를 나눈것, 뷰는 모델이 없으면 의미ㄴㄴ, ∴jsp만 호출하면 모델이 없음 -->

<link href="/css/style.css" type="text/css" rel="stylesheet">
</head>

<body>
   <!--header block ----------------------------------------------------------------------------------------------------------------- -->

   <jsp:include page="../inc/header.jsp"/>   

   <div id="visual">
      <div class="content-box">
         <!--   <span>보보보언니</span> 
            <img src="http://blogfiles.naver.net/MjAxODA5MTZfMjgw/MDAxNTM3MTAzODg3NDcy.o6wYmuayCV2lYG8yuNX5nq0hJwhNsbe0r3Q15xG3j6wg.mn-aYPzUQ2VTss4BRxCyXR_m4aRVF10XZdcjmMaMZEog.JPEG.09mmjiyoon/20180916_1323505930.jpg">
            <span>바보바보바보야</span>
            <img src="http://post.phinf.naver.net/MjAxNzEyMDhfNDIg/MDAxNTEyNzIxNDUyMzc4.Vo9sfxImkLvkGHRC9XdDL24GKu47He19K-2CN-tfpmcg.UB3tvdcrSGLB1FUP5Njgx724jG1G7l_Ph56xZBY52XIg.JPEG/IcFL8dbgYvPz4T_yqWEoDWEIdGUw.jpg"> 
            -->
      </div>
   </div>

   <div id="body">
      <div class="content-box">

         <jsp:include page="../inc/aside.jsp"/>   

         <main>
            <section id="main">
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
                  <h1>공지사항 내용</h1>
                  <table>
                     <tbody>
                        <tr>
                           <th>제목</th>
                           <td>${notice.title}</td>
                        </tr>
                        <tr>
                           <th>작성일</th>
                           <td>${notice.regDate}</td>
                        </tr>
                        
                        <tr>
                           <th>작성자</th>
                           <td>${notice.writerId}</td>
                           <th>조회수</th>
                           <td>${notice.hit}</td>
                        </tr>
                        
                        <tr>
                           <th>첨부파일</th>
                           <td>
                              <c:forEach var="noticeFile" items="${noticeFiles}">
                                 <a href="/upload/${noticeFile.name}" download>${noticeFile.name}</a>
                              </c:forEach>
                           </td>
                        </tr>
                        
                        <tr>
                           <th>내용</th>
                           <td>${notice.content}</td>
                        </tr>
                     </tbody>
                  </table>
                  
                  <div>
                     <a href="edit?id=${notice.id}">수정</a>
                     <a href="del?id=${notice.id}">삭제</a>
                  </div>
               
                  
                  
               </section>
               
               
               <section>
                  <h1></h1>
                  <ul>
                     <li><span>이전글</span><a href="detail?id=${prev.id}">${prev.title}</a></li>
                     <li><span>다음글</span><a href="detail?id=${next.id}">${next.title}</a></li>
                  </ul>
               </section>
            </section>
         </main>
      </div>
   </div>

   <jsp:include page="../inc/footer.jsp"/>   

</body>
</html>