(() => {
  window.onload = () => eventhandler();
  var eventhandler = () => {
    try {
      fetch("http://localhost:8080/students")
        .then((res) => res.json())
        .then((data) => addElements(data));
    } catch (e) {
      console.error(e);
    }
  };

  var addElements = (data) => {
    var root = document.getElementById("root");
    if (data) {
      for (let i of data) {
        console.log(i);
        let element = document.createElement("div");
        element.append(
          (document.createElement("h2").innerHTML = "Name " + i.firstName)
        );
        element.append(
          (document.createElement("h2").innerHTML = " " + i?.lastName)
        );
        let subDetails = document.createElement("div");
        subDetails.innerHTML = "couse taken: ";
        for (let c of i?.courseTaken) {
          subDetails.append(
            (document.createElement("h5").innerHTML = " " + c.name)
          );
        }

        element.append(subDetails);
        root.append(element);
      }
    }
  };
})();
