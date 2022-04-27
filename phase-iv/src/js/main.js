window.onload = function () {

    let loadCourses = () => {
        let courseTable = document
            .getElementById("course-table")
            .getElementsByTagName("tbody")[0];
        let courses = get('http://localhost:8080/api/v1/courses');
        courses.then(response => response.json())
            .then(data => {
                courseTable.innerHTML="";
                let select  = document.getElementById('course-taken');
                data.forEach(row => {
                    const option = document.createElement('option');
                    option.value = row.id;
                    option.innerHTML = row.code;
                    select.appendChild(option);
                    addCourseRow(courseTable, row);
                });
            });
    }

    let loadStudents = () => {
        let studentTable = document
            .getElementById("student-table")
            .getElementsByTagName("tbody")[0];
        let students = get('http://localhost:8080/api/v1/students');
        students.then(response => response.json())
            .then(data => {
                studentTable.innerHTML="";
                data.forEach(row => {
                    addStudentRow(studentTable, row);
                });
            });
    }

    document.getElementById('create-course').onclick = function(event){
        event.preventDefault();
        let data = {
                "name": document.getElementById('course-name').value,
                "code": document.getElementById('course-code').value
        }
        create('http://localhost:8080/api/v1/courses', data);
        document.getElementById("course-form").reset();
        loadCourses();
    }

    document.getElementById('create-student').onclick = function(event){
        event.preventDefault();
        const selected = document.querySelectorAll('#course-taken option:checked');
        const values = Array.from(selected).map(el => {
            return {"id":el.value};
        });
        let data = {
            "firstName": document.getElementById('first-name').value,
            "lastName": document.getElementById('last-name').value,
            "email": document.getElementById('email').value,
            "major": document.getElementById('major').value,
            "gpa": document.getElementById('gpa').value,
            "coursesTaken":values
        }
        create('http://localhost:8080/api/v1/students', data);
        document.getElementById("student-form").reset();
        loadCourses();
    }

    loadCourses();
    loadStudents();

    const addCourseRow = (table, data) => {
        let row = table.insertRow();
        let id = row.insertCell(0);
        let name = row.insertCell(1);
        let code = row.insertCell(2);
        id.innerHTML = data.id;
        name.innerHTML = data.name;
        code.innerHTML = data.code;
    };

    const addStudentRow = (table, data) => {
        let row = table.insertRow();
        let id = row.insertCell(0);
        let firstName = row.insertCell(1);
        let lastName = row.insertCell(2);
        let email = row.insertCell(3);
        let major = row.insertCell(4);
        let courseTaken = row.insertCell(5);
        id.innerHTML = data.id;
        firstName.innerHTML = data.firstName;
        lastName.innerHTML = data.lastName;
        email.innerHTML = data.email;
        major.innerHTML = data.major;
        courseTaken.innerHTML= data.coursesTaken.map(course => course.name).join(',');
    };


     function create(url,data) {
         fetch(url, {
            method: "POST",
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify(data),
        }).then((res) => {
            if (res.status === 200) {
                alert("Added successfully");
            }
        });
    }

    function get(url) {
        let playlists =  fetch(url, {
            method: "GET",
        });
        return playlists;
    }

};
