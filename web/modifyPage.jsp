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
<c:if test="${exists == true}">


<div class="container-fluid" style="margin-top: 100px;">

    <div class="row">
        <div class="col-sm-4" >

            <form action="modifyUser" method="post">
                <div class="form-group">
                    <label for="formGroupExampleInput">Новое имя</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" name = "name" placeholder="Bмя">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput2">Новая роль</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" name = "role" placeholder="Новая роль">
                </div>
                <div class="form-group">
                    <label for="id1">Id</label>
                    <input type="text" class="form-control" id="id1" name = "id"  value="<c:out value="${id}"/>" >
                </div>

                <input class="btn btn-primary" type="submit" value="Submit">
            </form>


        </div>



        <div class="col-sm-4" ></div>
        <div class="col-sm-4">

            <table class="table">
                <thead>
                <tr>

                    <th scope="col">Message</th>
                    <th scope="col">to</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="message" items="${messages}">
                    <tr>
                        <td><c:out value="${message.message}" /></td>
                        <td><c:out value="${message.to}" /></td>
                    </tr>


                </c:forEach>
                </tbody>
            </table>


        </div>
    </div>
</div>

</c:if>
<c:if test="${exists == false}">

    <p>Попытка модифицировать не существующего юзера</p>

</c:if>

</body>
</html>
