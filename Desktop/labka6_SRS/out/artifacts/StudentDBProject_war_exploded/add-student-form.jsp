
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.html"%>
<title>Студентті қосу</title>
</head>
<body>
<div class="container mycontainer">
  <div class="row">
    <div class="col-md-4 col-md-offset-2">
      <form action="/students" method="get" class="form-group">

        <input type="hidden" name="command" value="add">

        <label for="firstName">Есімі:</label>
        <input type="text" name="firstName" id="firstName" class="form-control">

        <label for="lastName">Тегі:</label>
        <input type="text" name="lastName" id="lastName" class="form-control">

        <label for="email">Email:</label>
        <input type="text" name="email" id="email" class="form-control">

        <label for="phone_number">Phone:</label>
        <input type="text" name="phone_number" id="phone_number" class="form-control">

        <label for="address">Address:</label>
        <input type="text" name="address" id="address" class="form-control">

        <br/>
        <button type="submit" class="btn btn-default">Қосу</button>
      </form>

      <br><br/><br/>
      <a href="/students">Басты бет</a>
    </div>
  </div>
</div>

<%@ include file="footer.html"%>