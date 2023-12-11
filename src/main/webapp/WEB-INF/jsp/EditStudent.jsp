<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit Student</title>

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

</head>
<body>

    <div class="container">

        <h1 class="p-3"> Edit Student </h1>

        <form:form action="/saveStudent/${student.id }" method="post" modelAttribute="student">
			<form:input path="id" type="hidden"/>
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="name">Name</label>
            		<div class="col-md-6">
            		    <form:input type="text" path="name" id="name"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>

            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="email">Email</label>
            		<div class="col-md-6">
            			<form:input type="email" path="email" id="email"
            				class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>
            
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="phone">Phone</label>
            		<div class="col-md-6">
            			<form:input type="tel" path="phone" id="phone"
            				placeholder="123-456-7890" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
            				class="form-control input-sm" required="required" />
            			<small>Format: 123-456-7890</small>
            		</div>
            	</div>
            	
             <!-- Display student information -->
	        <h2>Edit Courses for ${student.name}</h2>
	        
	        <!-- Display existing courses and grades -->
		    <table class="table table-bordered">
		        <tr>
		            <th>Course</th>
		            <th>Grade</th>
		        </tr>
		        <c:forEach var="courseId" items="${student.courseIds}">
		            <tr>
		                <td>${availableCoursesMap[courseId]}</td>
		                <td>
		                    <input type="number" name="${courseId}" value="${student.courseGrades[courseId]}"/>
		                </td>
		            </tr>
		        </c:forEach>
		    </table>
	
	        <!-- Display available courses -->
	        <label>Select Courses:</label>
	        <form:select path="courseIds" multiple="true">
	            <form:options items="${availableCourses}" itemLabel="name" itemValue="id"/>
	        </form:select>
            
			

            <div class="row p-2">
            	<div class="col-md-2">
            		<button type="submit" value="Register" class="btn btn-success">Save</button>
            	</div>
            </div>

        </form:form>

    </div>

</body>

</html>