const form = document.querySelector("#add");

form.addEventListener("submit", function (event) {
    // stop form submission
    event.preventDefault();

    const id = form.elements["id"].value;
    const firstName = form.elements["firstName"].value;
    const lastName = form.elements["lastName"].value;
    const major = form.elements["major"].value;

    fetch('http://localhost:8080/api/v1/students', {
        method: 'POST',
        // mode: 'no-cors',
        body: JSON.stringify({
            id,
            firstName,
            lastName,
            major,
        }), // string or object
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (response.status === 200)
                alert("Add student successfully");
        });
});