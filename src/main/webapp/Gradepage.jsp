<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Grades</title>
  <!-- Link to the external CSS file (assuming it's located in the "CSS" folder) -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/cssstyles.css">
</head>
<body>
  <div class="grades-container">
    <h2>Your Grades</h2>
    <table>
      <tr>
        <th>Subject</th>
        <th>Grade</th>
      </tr>
      <!-- Dynamic content can be added here using JSP tags -->
      <tr>
        <td>Math</td>
        <td>A</td>
      </tr>
      <tr>
        <td>Science</td>
        <td>B+</td>
      </tr>
      <!-- Example of using JSP to loop through a list of subjects/grades -->
      <%-- 
      List<Grade> grades = (List<Grade>) request.getAttribute("grades");
      if (grades != null) {
          for (Grade grade : grades) {
              out.print("<tr><td>" + grade.getSubject() + "</td><td>" + grade.getGrade() + "</td></tr>");
          }
      }
      --%>
    </table>
  </div>
</body>
</html>
