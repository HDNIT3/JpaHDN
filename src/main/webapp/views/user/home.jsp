
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<h2 class="text-center mb-4">Danh sách Category</h2>
		
		<div class="row row-cols-1 row-cols-md-3 g-4">
			<c:forEach var="cate" items="${listcate}">
				<div class="col">
					<div class="card h-100 shadow-sm">
						<c:url value="/image?imagename=${cate.images}" var="imageUrl"></c:url>
								<img height="150" width="200" src="${imageUrl}" class="card-img-top" alt="${cate.categoryname}" />
						<div class="card-body text-center">
							<h5 class="card-title">${cate.categoryname}</h5>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<form action="/jpahdn/logout" method="get" style="display: inline;">
			<button type="submit" class="btn btn-link p-0 m-0">Đăng xuất</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
