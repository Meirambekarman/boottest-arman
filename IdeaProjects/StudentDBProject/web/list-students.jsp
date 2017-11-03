<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.html"%>
<title>Студенттер тізімі</title>
</head>
<body>

<div class="container mycontainer">
    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <a href="/add-student-form.jsp" class="btn btn-primary btn-lg">Студентті қосу</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>email</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>

                    <c:forEach var="student" items="${list_students}">
                        <c:url var="deleteLink" value="/students">
                            <c:param name="command" value="del"/>
                            <c:param name="studentId" value="${student.id}"/>
                        </c:url>
                        <c:url var="updateLink" value="/students">
                            <c:param name="command" value="load" />
                            <c:param name="studentId" value="${student.id}"/>
                        </c:url>
                    <tr>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}">Delete</a>
                        </td>
                    </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="footer.html"%>
