<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
    <style>
        body {

            text-align: center;
            margin: 20px;
        }

        form {
            padding: 60px;
            border: 1px solid black;
            display: inline-block;
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            margin-bottom: 12px;
        }
    </style>
</head>
<body>
    <h2>Add Employee</h2>
    <form method="post" action="EmployeeServlet">
        <label for="id">ID:</label>
        <input type="text" name="id" required><br>

        <label for="name">Name:</label>
        <input type="text" name="name" required><br>

        <label for="dateOfBirth">Date of Birth:</label>
        <input type="date" name="dateOfBirth" required><br>

        <label for="email">Email:</label>
        <input type="text" name="email" required><br>

        <label for="role">Role:</label>
        <input type="text" name="role" required><br>

        <label for="joiningDate">Joining Date:</label>
        <input type="date" name="joiningDate" required><br>

        <input type="submit" value="Add Employee">
    </form>
</body>
</html>
