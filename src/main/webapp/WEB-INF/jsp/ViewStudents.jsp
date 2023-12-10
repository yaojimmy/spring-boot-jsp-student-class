<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>View Students</title>
	<link rel="stylesheet"
        	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <script
        	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script
        	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
	 <div class="container">

        <h1 class="p-3"> Student List </h1>

        <form:form>

            <table class="table table-bordered">
            	<tr>
            		<th>Id</th>
            		<th>Name</th>
            		<th>Email</th>
            		<th>Phone</th>
            		<th>Courses</th>
            		<th>Edit</th>
            		<th>Delete</th>
            	</tr>

            	<c:forEach var="student" items="${list}">
                    <tr>
                		<td>${student.id}</td>
                		<td>${student.name}</td>
                		<td>${student.email}</td>
                		<td>${student.phone}</td>
                		<td><c:forEach var="courseId" items="${student.courseIds }">
                		${course }
                		</c:forEach>
                		</td>
                		<td><button type="button" class="btn btn-primary">
                		    <a href="/editStudent/${student.id}">Edit</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger">
                			<a href="/deleteStudent/${student.id}">Delete</a>
                		</button></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>
        
        <button type="button" class="btn btn-primary btn-block">
        	<a href="/addStudent">Add New Student</a>
        </button>

    </div>
    <div class="container">

        <h1 class="p-3"> Course List </h1>

        <form:form>

            <table class="table table-bordered">
            	<tr>
            		<th>Id</th>
            		<th>Name</th>
            		<th>Professor</th>
            		<th>Edit</th>
            	</tr>

            	<c:forEach var="course" items="${cList}">
                    <tr>
                		<td>${course.id}</td>
                		<td>${course.name}</td>
                		<td>${course.professor}</td>
                		<td><button type="button" class="btn btn-primary">
                		    <a href="/editCourse/${course.id}">Edit</a>
                		</button></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>
        
        <button type="button" class="btn btn-primary btn-block">
        	<a href="/addCourse">Add New Course</a>
        </button>

    </div>

</body>
</html>