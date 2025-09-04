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
	<table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>STT</th>
            <th>Category Name</th>
            <th>Image</th>
            <th>Category ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="cate" varStatus="STT">
            <tr>
                <td>${STT.index + 1}</td>
                <td>${cate.categoryname}</td>
                <td>${cate.images}</td>
                <td>${cate.id}</td>
                <td>
                    <a href="<c:url value='/admin/category/edit?id=${cate.id}'/>" class="btn btn-sm btn-primary">Edit</a>
                    <a href="<c:url value='/admin/category/delete?id=${cate.id}'/>" class="btn btn-sm btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>