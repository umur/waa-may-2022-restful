const serverUrl = 'http://localhost:8080/api';
let students = [];


window.onload = function () {
  // load data
  loadInitialData();

  // add student
  document.getElementById('btn-add-student').onclick = (event) => {
    event.preventDefault();
    addStudent();
    loadInitialData();
  }

  // edit student
  document.getElementById('btn-edit-student').onclick = async (event) => {
    event.preventDefault();
    await editStudent();
    await loadInitialData();
  }

  // delete student
  document.getElementById('btn-delete-student').onclick = async (event) => {
    event.preventDefault();
    await deleteStudent();
    await loadInitialData();
  }

  // Activate tooltip
  $('[data-toggle="tooltip"]').tooltip();

  // Select/Deselect checkboxes
  var checkbox = $('table tbody input[type="checkbox"]');
  $("#selectAll").click(function () {
    if (this.checked) {
      checkbox.each(function () {
        this.checked = true;
      });
    } else {
      checkbox.each(function () {
        this.checked = false;
      });
    }
  });
  checkbox.click(function () {
    if (!this.checked) {
      $("#selectAll").prop("checked", false);
    }
  });

}

const loadInitialData = async () => {
  // fetch students
  let url = `${serverUrl}/v1/students`;
  students = await getFetch(url);

  let tableData = '';
  students.forEach((student, index) => {
    const sn = index + 1;
    tableData += `
         <tr>
            <td>
              <span class="custom-checkbox">
                <input type="checkbox" id="checkbox${sn}" name="options[]" value="1">
                <label for="checkbox${sn}"></label>
              </span>
            </td>
            <td>${student.id}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.major}</td>
            <td>
              <a href="#editStudentModal" class="edit" data-toggle="modal"><i class="material-icons"
                  data-toggle="tooltip" onclick="displayEditStudent(${student.id})" title="Edit">&#xE254;</i></a>
              <a href="#deleteStudentModal" class="delete" data-toggle="modal"><i class="material-icons"
                  data-toggle="tooltip"  onclick="perserveStudentId(${student.id})" title="Delete">&#xE872;</i></a>
            </td>
          </tr>
    `
  });

  let template = `
  <table class="table table-striped table-hover">
        <thead>
          <tr>
            <th>
              <span class="custom-checkbox">
                <input type="checkbox" id="selectAll">
                <label for="selectAll"></label>
              </span>
            </th>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Major</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          
          ${tableData}
        </tbody>
      </table>
  `;

  document.getElementById('table-student').innerHTML = template;
}

const addStudent = async () => {
  let body = JSON.stringify({
    id: document.getElementById('id-add').value,
    firstName: document.getElementById('fname-add').value,
    lastName: document.getElementById('lname-add').value,
    email: document.getElementById('email-add').value,
    major: document.getElementById('major-add').value,
    gpa: document.getElementById('gpa-add').value,
    coursesTaken: null
  });
  await postFetch(`${serverUrl}/v1/students`, body);
  $('#addStudentModal').modal('hide');
}

const displayEditStudent = async (id) => {
  let student = students.find(s => s.id == id);
  document.getElementById('id-edit').value = student.id;
  document.getElementById('fname-edit').value = student.firstName;
  document.getElementById('lname-edit').value = student.lastName;
  document.getElementById('email-edit').value = student.email;
  document.getElementById('major-edit').value = student.major;
  document.getElementById('gpa-edit').value = student.gpa;
}

const editStudent = async () => {
  let id = parseInt(document.getElementById('id-edit').value);
  let body = JSON.stringify({
    id: id,
    firstName: document.getElementById('fname-edit').value,
    lastName: document.getElementById('lname-edit').value,
    email: document.getElementById('email-edit').value,
    major: document.getElementById('major-edit').value,
    gpa: document.getElementById('gpa-edit').value,
    coursesTaken: null
  });
  await putFetch(`${serverUrl}/v1/students/${id}`, body);
  $('#editStudentModal').modal('hide');
}

const perserveStudentId = (id) => {
  document.getElementById('deleteStudentId').innerHTML = id;
}

const deleteStudent = async () => {
  const deleteId = parseInt(document.getElementById('deleteStudentId').innerHTML);
  await deleteFetch(`${serverUrl}/v1/students/${deleteId}`);
  $('#deleteStudentModal').modal('hide');
}

const getFetch = async (path) => {
  return await fetch(path, {
    headers: {
      'Content-Type': 'application/json'
    },
    method: 'GET'
  }).then(response => response.json());
}

const postFetch = async (path, body) => {
  return await fetch(path, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body
  }).then(res => res);
}

const deleteFetch = async (path) => {
  return await fetch(path, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(res => res);
}

const putFetch = async (path, body) => {
  return await fetch(path, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body
  }).then(res => res);
}