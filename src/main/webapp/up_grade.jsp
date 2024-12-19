<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Marks</title>
  <!-- Link to the external CSS file (located in the "CSS" folder) -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/cssstyles.css">
</head>
<body>
  <div class="update-marks-container">
    <h2>Update Marks</h2>
    <!-- The form is submitting data to the "/update" endpoint -->
    <form action="<%= request.getContextPath() %>/update" method="POST">
      <label for="student">Student Name:</label>
      <input type="text" name="student" required>
      
      <label for="subject">Subject:</label>
      <input type="text" name="subject" required>
      
      <label for="marks">Marks:</label>
      <input type="number" name="marks" required>

      <button type="submit">Update Marks</button>
    </form>
  </div>
</body>
</html>
