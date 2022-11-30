(() => {
  window.onload = () => eventhandler();
  var eventhandler = () => {
    console.log("hello");

    var root = document.getElementById("root");

    root.append((document.createElement("div").innerHTML = "hello"));
    try {
      fetch("http://localhost:8080/students")
        .then((res) => res.json)
        .then((res) => console.log(res));
    } catch (e) {
      console.error(e);
    }
  };
})();
