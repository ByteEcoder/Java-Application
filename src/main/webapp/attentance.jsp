<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Attendance</title>
  <!-- Link to the external CSS file (assuming it's located in the "CSS" folder) -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/cssstyles.css">
</head>
<body>
  <div class="attendance-container">
    <h2>Your Attendance</h2>
    <table>
      <tr>
        <th>Date</th>
        <th>Status</th>
      </tr>
      <!-- Static attendance data -->
      <tr>
        <td>2024-12-01</td>
        <td>Present</td>
      </tr>
      <tr>
        <td>2024-12-02</td>
        <td>Absent</td>
      </tr>
      <!-- Dynamic attendance data (Optional) -->
      <%-- 
      List<Attendance> attendanceList = (List<Attendance>) request.getAttribute("attendanceList");
      if (attendanceList != null) {
          for (Attendance attendance : attendanceList) {
              out.print("<tr><td>" + attendance.getDate() + "</td><td>" + attendance.getStatus() + "</td></tr>");
          }
      }
      --%>
    </table>
  </div>
</body>
</html>
