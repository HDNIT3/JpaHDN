<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/jpahdn/admin/category/create" method="post" enctype="multipart/form-data">
		<label>Nhập tên</label>
		<input type="text" name="name">
		<div class="mb-3">
            <label for="image" class="form-label">Tải ảnh</label>
            <input type="file" class="form-control" name="imagename" accept="image/*">
        </div> 
        <button type="submit">Thêm Category</button>
	</form>
</body>
</html>