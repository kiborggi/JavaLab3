<%@ page import="java.util.ArrayList" %>
<%@ page import="clases.User" %><%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 28.12.2020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<html lang="en">
<head>
  <title>Lab3</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid" style="margin-top: 100px;">

  <div class="row">
    <div class="col-sm-4" ></div>
    <div class="col-sm-4" >
      <table class="table">
        <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">

          <tr>
            <th scope="row"><c:out value="${user.id}"/></th>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.role}" /></td>
            <td><a class="btn btn-primary" href="modify?id=<c:out value="${user.id}"/>" role="button">modify</a></td>

          </tr>


        </c:forEach>
        </tbody>
      </table>


      </div>
    <div class="col-sm-4"></div>
  </div>
</div>


</body>
</html>

