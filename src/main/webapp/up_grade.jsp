<form action="${pageContext.request.contextPath}/UpdateGradeServlet" method="POST">
  <label for="student">Student Name:</label>
  <input type="text" name="student" required>
  
  <label for="subject">Subject:</label>
  <input type="text" name="subject" required>
  
  <label for="marks">Marks:</label>
  <input type="number" name="marks" required>

  <button type="submit">Update Marks</button>
</form>
