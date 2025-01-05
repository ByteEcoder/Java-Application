<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssstyles.css">
</head>
<body>
  <div class="dashboard-container">
    <h1>Welcome, Student!</h1>
    <nav>
      <ul>
        <!-- Links to View Attendance and Grades -->
        <li><a href="${pageContext.request.contextPath}/attendance">View Attendance</a></li>
        <li><a href="${pageContext.request.contextPath}/grades">View Grades</a></li>
      </ul>
    </nav>
  </div>
</body>
</html>
