<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Grades</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssstyles.css">
</head>
<body>
  <div class="grades-container">
    <h2>Your Grades</h2>
    <table>
      <tr>
        <th>Subject</th>
        <th>Grade</th>
      </tr>
      <!-- Dynamic grades data -->
      <c:forEach var="grade" items="${grades}">
        <tr>
          <td>${grade.subject}</td>
          <td>${grade.grade}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>
