<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Student Courses</title>

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

    <form:form method="post" modelAttribute="student"
               action="/saveStudentCourses/${student.id}">

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

        <!-- Submit button -->
        <button type="submit">Save Changes</button>
    </form:form>

</body>
</html>
