const form = document.querySelector("#addCourse");

form.addEventListener("submit", function (event) {
    // stop form submission
    event.preventDefault();

    const courseId = form.elements["courseId"].value;
    const courseName = form.elements["courseName"].value;
    const courseCode = form.elements["courseCode"].value;

    console.log(courseName);

    fetch('http://localhost:8080/api/v1/courses', {
        method: 'POST',
        // mode: 'no-cors',
        body: JSON.stringify({
            id: courseId,
            name: courseName,
            code: courseCode,
        }), // string or object
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (response.status == 200)
                alert("Add course successfully");
        });
});