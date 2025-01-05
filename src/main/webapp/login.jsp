<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login - Attendance and Grades</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssstyles.css">
</head>
<body>
  <div class="login-container">
    <h2>Login</h2>
    <form id="loginForm" method="POST" action="${pageContext.request.contextPath}/LoginServlet">
      <input type="text" id="username" name="username" placeholder="Username" required>
      <input type="password" id="password" name="password" placeholder="Password" required>
      <button type="submit">Login</button>
    </form>
  </div>
</body>
</html>
