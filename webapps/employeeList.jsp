<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <table cellpadding="10" cellspacing="0" align="center" border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Email</th>
                <th>Role</th>
                <th>Joining Date</th>
                <th>Vacation Leave</th>
                <th>Sick Leave</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td align="center">${employee.getId()}</td>
                    <td align="center">${employee.getName()}</td>
                    <td align="center">${employee.getDateOfBirth()}</td>
                    <td align="center">${employee.getEmail()}</td>
                    <td align="center">${employee.getRole().toUpperCase()}</td>
                    <td align="center">${employee.getJoiningDate()}</td>
                    <td align="center">${employee.getVacationLeave()}</td>
                    <td align="center">${employee.getSickLeave()}</td>
                    <!-- Add more columns for other employee details -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <form method="post" action="addEmployee.jsp" align="center" padding="1px">
        <button type="submit"> Add Employee </button>
    </form>
</body>
</html>
