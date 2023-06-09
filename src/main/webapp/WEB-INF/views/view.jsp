<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand">Navbar</a>
    </div>
    </div>
</nav>

<section style="padding: 15px">

    <nav class="navbar-expand-lg bg-light">
        <div class="container-fluid" style="margin-bottom: 10px">
            <b>Featured</b>
        </div>
    </nav>
    <br>
    <div class="card">
        <form>
            <div class="input-group mb-3">
                <span class="input-group-text">Tno</span>
                <input type="text" class="form-control" name="tno" value="${dto.tno}" disabled readonly>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Title</span>
                <input type="text" class="form-control" name="title" value="${dto.title}" disabled readonly>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">DueDate</span>
                <input type="date" class="form-control" name="dueDate" value="${dto.dueDate}" disabled readonly>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Writer</span>
                <input type="text" class="form-control" name="writer" value="${dto.writer}" disabled readonly>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" name="finished" disabled <c:if test="${dto.finished eq '1'}">checked</c:if> >
                <label class="form-check-label" for="flexCheckDefault">
                    Finished
                </label>
            </div>

            <button type="button" style="float: right; margin: 5px"  class="btn btn-secondary"  onclick="location.href='/list?page=<%= request.getParameter("page")%>'">List</button>
            <a style="float: right; margin: 5px" class="btn btn-primary" href='/modify?tno=${dto.tno}'>Modify</a>
        </form>
    </div>

</section>
</body>
</html>