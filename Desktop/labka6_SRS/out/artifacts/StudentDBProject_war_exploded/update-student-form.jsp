
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.html"%>
<title>update page</title>
</head>
<body>
<div class="container mycontainer">
  <div class="row">
    <div class="col-md-4 col-md-offset-2">
      <form action="/students" method="get" class="form-group">

        <input type="hidden" name="command" value="update" />
        <input type="hidden" name="studentId" value="${the_student.id}" />

        <label for="firstName">Есімі:</label>
        <input type="text" name="firstName" value="${the_student.firstName}" id="firstName" class="form-control">

        <label for="lastName">Тегі:</label>
        <input type="text" name="lastName" value="${the_student.lastName}" id="lastName" class="form-control">

        <label for="email">Email:</label>
        <input type="text" name="email" value="${the_student.email}" id="email" class="form-control">

        <label for="phone_number">Phone:</label>
        <input type="text" name="phone_number" value="${the_student.phone_number}" id="phone_number" class="form-control">

        <label for="address">Address:</label>
        <input type="text" name="address" value="${the_student.address}" id="address" class="form-control">

        <br/>
        <button type="submit" class="btn btn-default">Жаңарту</button>
      </form>


    </div>
</div>
<%@include file="footer.html"%>