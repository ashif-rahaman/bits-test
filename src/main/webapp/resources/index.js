
var showEmployee = function (id) {

    var display = document.getElementById("employee_info");
    display.style.display = "inline";

    console.log(display);

    var employee = document.getElementById(id);

//    console.log(employee);

    if (employee.children[0].firstChild != null)
        display.children[0].value = employee.children[0].firstChild.data;

    if (employee.children[1].firstChild != null)
        display.children[2].value = employee.children[1].firstChild.data;

    if (employee.children[2].firstChild != null)
        display.children[4].value = employee.children[2].firstChild.data;

    if (employee.children[3].firstChild != null)
        display.children[6].value = employee.children[3].firstChild.data;

    if (employee.children[4].firstChild != null)
        display.children[8].value = employee.children[4].firstChild.data;

    if (employee.children[5].firstChild != null)
        display.children[10].value = employee.children[5].firstChild.data;

    if (employee.children[6].firstChild != null)
        display.children[12].value = employee.children[6].firstChild.data;
};

var changeType = function (action) {

    document.getElementById("action").value = action;

    console.log(document.getElementById("action").value);
};


