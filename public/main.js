var courses = [];

const getCourse = async ()=>{
  let response = await fetch("http://localhost:8080/api/v1/courses");
   courses = await response.json();
   let element = document.getElementById("courseTaken");
   let html = courses.map(item=>{
     return `<option value="${item.id}">${item.name}</option>`;
   });
   element.innerHTML = `
   <option selected>Choose</option>
   ${html}
   `;
}
getCourse();

const getStudent = async function () {
  let response = await fetch("http://localhost:8080/api/v1/students");
  let students = await response.json();
//  firstName,lastName,email,major,courseTaken,gpa,
  appendStudentTable(students);
};
getStudent();
document.getElementById("addBtn").onclick = async function (evt) {
  evt.preventDefault();
  //firstName,lastName,email,major,courseTaken,gpa,
  let select = document.getElementById("courseTaken");
  let selected = [...select.selectedOptions]
      .map(option => option.value);
  selected = selected.map(item=>{
    let course = null;
    courses.map(c=>{if(parseInt(c.id)==parseInt(item)){
      course = c;
    }});
    return course;
  });
  const student = {
    id: document.getElementById("id").value,
    firstName: document.getElementById("firstName").value,
    lastName: document.getElementById("lastName").value,
    email: document.getElementById("email").value,
    major: document.getElementById("major").value,
    gpa: document.getElementById("gpa").value,
    courseTaken: selected,
  };
  console.log("here------->",student);
  let route = "http://localhost:8080/api/v1/students";
  let method = "POST";
  if (document.getElementById("sid")) {
    student.id = document.getElementById("sid").value;
    method = "PUT";
    route += "/" + student.id;
  }

  const response = await fetch(route, {
    method: method,
    body: JSON.stringify(student),
    headers: {
      "Content-Type": "application/json",
    },
  });
  if(response.status ===200){
    getStudent();
    document.getElementById("addBtn").innerHTML = "Add New Student";
    document.getElementById("bookForm").reset();
  }

};

async function update(id) {
  let response = await fetch("http://localhost:8080/api/v1/students/" + id);
  let stu = await response.json();

  document.getElementById("id").value = stu.id;
  document.getElementById("firstName").value = stu.firstName;
  document.getElementById("lastName").value = stu.lastName;
  document.getElementById("email").value = stu.email;
  document.getElementById("major").value = stu.major;
  document.getElementById("gpa").value = stu.gpa;
  let selectEle = document.getElementById("courseTaken");
  selectEle.options[0].selected = false;
  stu.courseTaken.map(item=>{
    courses.map(c=>{
      if(parseInt(item.id)===parseInt(c.id)){
        selectEle.options[item.id].selected = true;
      }
    })
  })

  window.scrollTo(0, 0);
  document.getElementById("id").focus();
  let input = document.createElement("input");
  input.type = "hidden";
  input.value = id;
  input.id = "sid";
  document.getElementById("addBtn").innerHTML = "Update Student";
  document.getElementById("bookForm").append(input);
}
async function deleteBook(id) {
  const response = await fetch("http://localhost:8080/api/v1/students/" + id, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
  getStudent();
}

document.getElementById("search").onclick = async function (evt) {
  let value = document.getElementById('search-input').value;
  const response = await fetch("http://localhost:8080/api/v2/students?major="+value);
  const result = await response.json();
  appendStudentTable(result);

}

const appendStudentTable = (students)=>{

  let template = `
            <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Major</th>
                    <th>GPA</th>
                    <th>Course Taken</th>
                    <th></th>
                </tr> 
                </thead>
                <tbody>
        `;
  students.forEach((item) => {
    let course = ""
    item.courseTaken.map(item=>{
      course+=item.name+",";
    });
    course = course.slice(0, -1);
    template += `
            <tr>
                <td class="id">${item.id}</td>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
                <td>${item.email}</td>
                <td>${item.major}</td>
                
                <td>${item.gpa}</td>
                <td>${course}</td>
                <td style="width:250px;">
                  <button class="btn btn-warning" onclick="update(${item.id})">Update</button>
                  <button class="btn btn-danger" onclick="deleteBook(${item.id})">Delete</button>
                </td>
            </tr>
            `;
  });
  template += "</tbody></table>";
  document.getElementById("student").innerHTML = template;
}