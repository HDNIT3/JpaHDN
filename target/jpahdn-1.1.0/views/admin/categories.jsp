<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="card shadow-lg rounded-3">
			<div class="card-header bg-primary text-white text-center">
				<h3 class="mb-0">Danh sách Category</h3>
			</div>
			<div class="card-body">
				<table class="table table-hover align-middle">
					<thead class="table-dark text-center">
						<tr>
							<th>STT</th>
							<th>Category Name</th>
							<th>Image</th>
							<th>Category ID</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach items="${listcate}" var="cate" varStatus="STT">
							<tr>
								<td>${STT.index + 1}</td>
								<td class="fw-semibold">${cate.categoryname}</td>
								<c:url value="/image?imagename=${cate.images}" var="imageUrl"></c:url>
								<td><img height="150" width="200" src="${imageUrl}" /></td>
								<td>${cate.id}</td>
								<td><a
									href="<c:url value='/admin/category/edit?id=${cate.id}'/>"
									class="btn btn-sm btn-warning me-2">Edit</a> <a
									href="<c:url value='/admin/category/delete?id=${cate.id}'/>"
									class="btn btn-sm btn-danger"
									onclick="return confirm('Bạn có chắc muốn xóa category này?');">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="/jpahdn/admin/category/create" method="get" style="display: inline;">
					<button type="submit" class="btn btn-link p-0 m-0">Thêm Category</button>
				</form>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
