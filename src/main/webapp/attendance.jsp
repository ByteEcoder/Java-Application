<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Attendance</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssstyles.css">
</head>
<body>
  <div class="attendance-container">
    <h2>Your Attendance</h2>
    <table>
      <tr>
        <th>Date</th>
        <th>Status</th>
      </tr>
      <!-- Dynamic attendance data -->
      <c:forEach var="attendance" items="${attendanceList}">
        <tr>
          <td>${attendance.date}</td>
          <td>${attendance.status}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>
