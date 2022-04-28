const getCourse = async function () {
    let response = await fetch("http://localhost:8080/api/v1/courses");
    let courses = await response.json();

    let template = `
            <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Code</th>
                </tr> 
               </thead>
               <tbody>
        `;
    courses.forEach((item) => {
        template += `
            <tr>
                <td class="id">${item.id}</td>
                <td>${item.name}</td>
                <td>${item.code}</td>
                <td style="width:250px;">
                  <button class="btn btn-warning" onclick="update(${item.id})">Update</button>
                  <button class="btn btn-danger" onclick="deleteBook(${item.id})">Delete</button>
                </td>
            </tr>
            `;
    });
    template += "</tbody></table>";
    document.getElementById("books").innerHTML = template;
};
getCourse();
document.getElementById("addBtn").onclick = async function (evt) {
    evt.preventDefault();

    const course = {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        code: document.getElementById("code").value,
    };

    let route = "http://localhost:8080/api/v1/courses";
    let method = "POST";
    if (document.getElementById("cid")) {
        course.id = document.getElementById("cid").value;
        method = "PUT";
        route += "/" + course.id;
    }

    const response = await fetch(route, {
      method: method,
      body: JSON.stringify(course),
      headers: {
        "Content-Type": "application/json",
      },
    });
    if(response.status==200){
        getCourse();
        document.getElementById("addBtn").innerHTML = "Add New Course";
        document.getElementById("courseForm").reset();
    }


};

async function update(id) {
    let response = await fetch("http://localhost:8080/api/v1/courses/" + id);
    let course = await response.json();
    console.log(course);
    document.getElementById("id").value = course.id;
    document.getElementById("name").value = course.name;
    document.getElementById("code").value = course.code;

    window.scrollTo(0, 0);
    document.getElementById("id").focus();
    let input = document.createElement("input");
    input.type = "hidden";
    input.value = id;
    input.id = "cid";
    document.getElementById("addBtn").innerHTML = "Update Book";
    document.getElementById("courseForm").append(input);
}
async function deleteBook(id) {
    const response = await fetch("http://localhost:8080/api/v1/courses/" + id, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    });
    getCourse();
}
