<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Book</title>
	</head>
	<body>
	<%@ include file="include/menu.jsp" %>
			<div>
				<form method="post" action="/ssr/book/edit/${ book.id }">
				    ID:  <input type="number" name="id" value="${ book.id }" readonly/><p />
				    書名: <input type="text" name="name" value="${ book.name }" required/><p />
				    價格: <input type="number" name="price" value="${ book.price }" required/><p />
				    數量: <input type="number" name="amount" value="${ book.amount }" required/><p />
				    出刊: <input type="checkbox" name="pub" ${ book.pub? "checked": "" }/><p />
				    <button type="submit">送出</button>
				</form>
			</div>
	</body>
</html>