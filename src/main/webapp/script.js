// Form Handling & Validation
document.getElementById('attendanceGradeForm').addEventListener('submit', function(e) {
    e.preventDefault();
  
    const studentId = document.getElementById('studentId').value.trim();
    const studentName = document.getElementById('studentName').value.trim();
    const attendance = document.getElementById('attendance').value.trim();
    const grade = document.getElementById('grade').value.trim();
  
    if (!studentId || !studentName || !attendance || !grade) {
      alert('Please fill all fields!');
      return;
    }
  
    addOrUpdateRecord(studentId, studentName, attendance, grade);
    this.reset();
  });
  
  // Function to Add or Update Record in Table
  function addOrUpdateRecord(id, name, attendance, grade) {
    const table = document.getElementById('recordsTable');
    let row = document.querySelector(`tr[data-id="${id}"]`);
  
    if (row) {
      // Update existing row
      row.innerHTML = createRowContent(id, name, attendance, grade);
    } else {
      // Add new row
      row = document.createElement('tr');
      row.setAttribute('data-id', id);
      row.innerHTML = createRowContent(id, name, attendance, grade);
      table.appendChild(row);
    }
  }
  
  // Create Row Content
  function createRowContent(id, name, attendance, grade) {
    return `
      <td>${id}</td>
      <td>${name}</td>
      <td>${attendance}%</td>
      <td>${grade}</td>
      <td>
        <button class="btn btn-danger btn-sm" onclick="deleteRecord('${id}')">Delete</button>
      </td>
    `;
  }
  
  // Delete Record
  function deleteRecord(id) {
    const row = document.querySelector(`tr[data-id="${id}"]`);
    if (row) row.remove();
  }
  