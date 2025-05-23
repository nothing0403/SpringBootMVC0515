<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Book List</title>
		
		<!-- DataTables CSS -->
		<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"/>
		
		<!-- jQuery（必要）-->
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		
		<!-- DataTables JS -->
		<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
		
		<!-- Buttons 插件 -->
		<link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.4.1/css/buttons.dataTables.min.css"/>
		<script src="https://cdn.datatables.net/buttons/2.4.1/js/dataTables.buttons.min.js"></script>
		<script src="https://cdn.datatables.net/buttons/2.4.1/js/buttons.html5.min.js"></script>
		<script src="https://cdn.datatables.net/buttons/2.4.1/js/buttons.print.min.js"></script>
		
		<!-- PDF & Excel 匯出支援 -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.68/pdfmake.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.68/vfs_fonts.js"></script>
		
	</head>
	<body>
		<%@ include file="include/menu.jsp" %>
		<div>
		    <h1>Book List</h1>
			<form method="post" action="/ssr/book/add">
			    書名: <input type="text" name="name" required/><p /> <!-- name = value -->
			    價格: <input type="number" name="price" required/><p /> <!-- number = value -->
			    數量: <input type="number" name="amount" required/><p /> <!-- amount = value -->
			    出刊: <input type="checkbox" name="pub"/><p /> <!-- pub = value(on (value預設值)) -->
			    <button type="submit">送出</button>
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th><th>書名</th><th>價格</th><th>數量</th><th>出刊</th><th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${ books }">
						<tr>
							<td>${ book.id }</td>
							<td>${ book.name }</td>
							<td>${ book.price }</td>
							<td>${ book.amount }</td>
							<td>${ book.pub }</td>
							<td>
							    <a href="/ssr/book/edit/${ book.id }">修改</a> 
								&nbsp;|&nbsp; 
								<a href="/ssr/book/delete/${ book.id }">刪除</a>
								<form style="display: inline" method="post" action="/ssr/book/delete/${ book.id }">
								    <input type="hidden" name="_method" value="DELETE"/>
								    <button type="submit">刪除</button>
								</form>
								&nbsp;|&nbsp;
								<a href="#" onclick="deleteBook(${ book.id })">刪除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>