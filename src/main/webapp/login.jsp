<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login - Attendance and Grades</title>
  <!-- Link to the external CSS file (located in the "CSS" folder) -->
  <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/cssstyles.css">
</head>
<body>
  <div class="login-container">
    <h2>Login</h2>
    <form id="loginForm" method="POST" action="<%= request.getContextPath() %>/authenticate">
      <input type="text" id="username" name="username" placeholder="Username" required>
      <input type="password" id="password" name="password" placeholder="Password" required>
      <button type="submit">Login</button>
    </form>
  </div>

  <script>
    document.getElementById('loginForm').addEventListener('submit', function(e) {
      e.preventDefault();
      const username = document.getElementById('username').value;
      const password = document.getElementById('password').value;

      // Simulate a backend call to check user type (You can replace this with a real API call)
      fetch('<%= request.getContextPath() %>/authenticate', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
      })
      .then(response => response.json())
      .then(data => {
        if (data.role === 'student') {
          window.location.href = '<%= request.getContextPath() %>/student-dashboard';
        } else if (data.role === 'teacher') {
          window.location.href = '<%= request.getContextPath() %>/teacher-dashboard';
        } else {
          alert('Invalid login credentials');
        }
      })
      .catch(error => console.error('Error:', error));
    });
  </script>
</body>
</html>
