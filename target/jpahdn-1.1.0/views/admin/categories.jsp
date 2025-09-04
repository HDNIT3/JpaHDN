<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c: forEach items="${listcate}" var="list">
	 ${list.id}
	 <br />
	 ${list.categoryname}
	</c: ForEach>
</body>
</html>