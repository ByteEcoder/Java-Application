<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssstyles.css">  <!-- Corrected the path for CSS -->
</head>
<body>

<h2>User Registration</h2>

<!-- Form submission will post to the RegisterServlet -->
<form action="${pageContext.request.contextPath}/RegisterServlet" method="POST">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="role">Role:</label>
    <select id="role" name="role">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
    </select><br><br>

    <input type="submit" value="Register">
</form>

<!-- Display any error messages from the backend (optional) -->
<c:if test="${not empty errorMessage}">
    <div class="error-message">${errorMessage}</div>
</c:if>

</body>
</html>
