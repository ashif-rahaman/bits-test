<%--
    Document   : index
    Created on : Jul 3, 2018, 11:59:26 PM
    Author     : ashif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>

        <spring:url value="/resources/index.js" var="index"/>

        <script src="${index}" type="text/javascript"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
    </head>
    <body>
        <div>
            <table cellspacing="100">
                <tr>
                    <td>
                        <form action="insert" method="POST" modelAttribute="user" modelAttribute="employee">

                            <input type="text" name="name" placeholder="Name"/></br>
                            <input type="text" name="pin" placeholder="Pin"/></br>
                            <input type="text" name="fatherName" placeholder="Father Name"/></br>
                            <input type="text" name="motherName" placeholder="Mother Name"/></br>
                            <input type="date" name="dob"/></br>
                            <input type="number" name="salary" placeholder="Salary" min="0"/>

                            <input type="submit" value="Insert"/>
                        </form>
                    </td>

                    <td>
                        <form action="update" method="POST" modelAttribute="user" id="employee_info" style="display: none">

                            <input type="number" name="id" placeholder="Id"/></br>
                            <input type="text" name="name" placeholder="Name"/></br>
                            <input type="text" name="pin" placeholder="Pin"/></br>
                            <input type="text" name="fatherName" placeholder="Father Name"/></br>
                            <input type="text" name="motherName" placeholder="Mother Name"/></br>
                            <input type="date" name="dob"/></br>
                            <input type="number" name="salary" placeholder="Salary" min="0"/></br>

                            <input type="text" name="type" style="display: none" id="action">

                            <input type="submit" value="Delete" onfocus="changeType('delete')"/>
                            <input type="submit" value="Update" onfocus="changeType('update')"/>
                        </form>
                    </td>
                </tr>
            </table>

            <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>PIN</td>
                    <td>Father Name</td>
                    <td>Mother Name</td>
                    <td>DOB</td>
                    <td>Salary</td>
                </tr>
                <c:forEach items="${employees}" var="employee">

                    <tr id="<c:out value="${employee.id}"></c:out>" onclick="showEmployee(<c:out value="${employee.id}"></c:out>)">
                        <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <td>${employee.pin}</td>
                        <td>${employee.fatherName}</td>
                        <td>${employee.motherName}</td>
                        <td>${employee.dob}</td>
                        <td>${employee.salary}</td>
                    </tr>

                </c:forEach>
            </table>

        </div>
    </body>
</html>
