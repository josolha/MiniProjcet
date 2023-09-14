<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
  <a class="navbar-brand" href="#">Logo</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
    </ul>
  </div>
</nav>
<!-- /Navbar -->

<div class="container shadow mt-5 w-25 rounded p-5">
	<h2 class="text-center mb-3">회원가입</h2>
    <form action="/user/register" method="post">
        
        <div class="form-group row">
            <label for="userId" class="col-sm-3 col-form-label text-nowrap">User ID:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="userId" name="userId" required>
            </div>
        </div>

        <div class="form-group row">
            <label for="password" class="col-sm-3 col-form-label text-nowrap">Password:</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
        </div>

        <div class="form-group row">
            <label for="fullName" class="col-sm-3 col-form-label text-nowrap">Full Name:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="fullName" name="fullName" required>
            </div>
        </div>

        <div class="form-group row">
            <label for="nickname" class="col-sm-3 col-form-label text-nowrap">Nickname:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="nickname" name="nickname">
            </div>
        </div>

        <div class="form-group row">
            <label for="birthdate" class="col-sm-3 col-form-label text-nowrap">Birth Date:</label>
            <div class="col-sm-9">
                <input type="date" class="form-control" id="birthdate" name="birthdate">
            </div>
        </div>

        <div class="form-group row">
            <label for="phone" class="col-sm-3 col-form-label text-nowrap">Phone:</label>
            <div class="col-sm-9">
                <input type="tel" class="form-control" id="phone" name="phone">
            </div>
        </div>

        <div class="form-group row">
            <label for="email" class="col-sm-3 col-form-label">Email:</label>
            <div class="col-sm-9">
                <input type="email" class="form-control" id="email" name="email">
            </div>
        </div>

        <div class="form-group row">
            <label for="address" class="col-sm-3 col-form-label">Address:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="address" name="address">
            </div>
        </div>

        <button type="submit" class="btn btn-dark d-block mx-auto">가입하기</button>
    </form>
</div>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
