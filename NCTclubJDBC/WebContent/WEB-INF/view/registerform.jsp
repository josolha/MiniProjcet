<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- header html -->
<%@ include file="inc/header.jsp"%>


<!-- main html -->
<div class="container shadow py-5 w-25 rounded p-5 my-auto">
<h2 class="text-center mb-3">회원가입</h2>
    <form action='${ctxPath}/user/register' method='post'>
            <div class="form-group row">
            <label for="userId" class="col-sm-3 col-form-label text-nowrap">아이디:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="userId" name="userId" required>
            </div>
        </div>

        <div class="form-group row">
            <label for="password" class="col-sm-3 col-form-label text-nowrap">비밀번호:</label>
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
<!-- footer html -->
<%@ include file="inc/footer.jsp" %>