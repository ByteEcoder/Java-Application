<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Attendance & Grade Management</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cssstyles.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <h1 class="text-center mb-4">Manage Attendance & Grades</h1>

  <!-- Add Attendance & Grade Form -->
  <form id="attendanceGradeForm" class="mb-4">
    <div class="row mb-3">
      <div class="col">
        <label for="studentId" class="form-label">Student ID</label>
        <input type="text" class="form-control" id="studentId" placeholder="Enter Student ID" required>
      </div>
      <div class="col">
        <label for="studentName" class="form-label">Student Name</label>
        <input type="text" class="form-control" id="studentName" placeholder="Enter Student Name" required>
      </div>
    </div>

    <div class="row mb-3">
      <div class="col">
        <label for="attendance" class="form-label">Attendance (%)</label>
        <input type="number" class="form-control" id="attendance" placeholder="Enter Attendance Percentage" required>
      </div>
      <div class="col">
        <label for="grade" class="form-label">Grade</label>
        <input type="text" class="form-control" id="grade" placeholder="Enter Grade" required>
      </div>
    </div>

    <button type="submit" class="btn btn-primary w-100">Add / Update Record</button>
  </form>

  <!-- Display Table -->
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Attendance (%)</th>
        <th>Grade</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody id="recordsTable">
      <!-- Rows will be dynamically added here -->
    </tbody>
  </table>
</div>

<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
