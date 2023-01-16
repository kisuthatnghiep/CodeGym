function displayEmployee(employee) {
    return `<td>${employee.code}</td>
            <td><p style="cursor: pointer" onclick="passIdDetail(${employee.id})">${employee.name}</p></td>
            <td>${employee.age}</td>
            <td>${employee.salary}</td>
            <td>${employee.branch.name}</td>
            <td><button class="btn btn-warning" onclick="passEmployeeUpdate(${employee.id})">Update</button></td>
            <td><button class="btn btn-danger" onclick="deleteEmployee(${employee.id})">Delete</button></td>`
}

function passIdDetail(id){
    window.localStorage.setItem("idUpdate", id);
    window.location.href = "Detail.html"
}
function passEmployeeUpdate(id){
    window.localStorage.setItem("idUpdate1", id);
    window.location.href = "update.html"
}

function getAllEmployee() {
    $.ajax(
        {
            type: "GET",
            url: "http://localhost:8080/employees",
            success: function (data) {

                let contentIndex = `<table class="table table-striped"><tr>
                            <th>EmployeeCode</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Action</th>
                            <th></th>
                            </tr>`;
                for (let i = 0; i < data[0].length; i++) {
                    contentIndex += `<tr class="paging">`
                    contentIndex += displayEmployee(data[0][i])
                    contentIndex += `</tr>`
                }
                window.localStorage.setItem("branch", JSON.stringify(data[1]));
                contentIndex += `</table>`
                $("#employee-list").html(contentIndex);
                let content1 = `<select class="form-select" id="filter" onchange="displayByBranch()">`
                        content1 += `<option value="all">Display all employee</option>`
                    for(let i = 0; i < data[1].length; i++){
                        content1 += `<option value="` + data[1][i].id + `">`+ data[1][i].name +`</option>`
                    }
                     content1 += `</select>`
                $("#idFilter").html(content1);
            }
        }
    );
}

function displayByBranch(){
    let id = $("#filter").val();
    if (id === "all"){
        getAllEmployee()
    }else {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "GET",
            url: "http://localhost:8080/employees/branch/" + id,
            success: function (data) {
                let contentIndex = `<table class="table table-striped"><tr>
                            <th>EmployeeCode</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Action</th>
                            <th></th>
                            </tr>`;
                for (let i = 0; i < data.length; i++) {
                    contentIndex += `<tr class="paging">`
                    contentIndex += displayEmployee(data[i])
                    contentIndex += `</tr>`
                }
                contentIndex += `</table>`
                $("#employee-list").html(contentIndex);
            }
        })
    }
}

function getOne() {
    let id = window.localStorage.getItem("idUpdate")
    $.ajax(
        {
            type: "GET",
            url: "http://localhost:8080/employees/" + id,
            success: function (data) {
                let content = ``;
                content += `<p><strong>Name: ` + data.name + `</strong></p>`
                content += `<p><strong>Salary: ` + data.salary + `</strong></p>`
                content += `<p><strong>Age: ` + data.age + `</strong></p>`
                content += `<p><strong>Department: ` + data.branch.name + `</strong></p>`
                $("#detail").html(content);
            }
        }
    );
}
function getBranch(){
    let branch = JSON.parse(window.localStorage.getItem("branch"));
    let content = `<label>Branch</label><select id="branch" class="form-select">`;
    for (let i = 0; i < branch.length; i++){
    content += `<option value="` + branch[i].id + `">`+ branch[i].name +`</option>`
    }
    content += `</select>`
    $("#branch_list").html(content);
    $(".hide").hide()
}
function createEmployee() {
    let code = $("#code").val()
    let name = $("#name").val()
    let age = $("#age").val()
    let salary = $("#salary").val()
    let branch = $("#branch").val()
    let flag = false;
    if (code === ""){
        $("#code1").show()
        flag = true;
    }else {
        $("#code1").hide()
    }
    if (name === ""){
        $("#name1").show()
        flag = true;
    }else {
        $("#name1").hide()
    }
    if (age === ""){
        $("#age1").show()
        flag = true;
    }else {
        $("#age1").hide()
    }
    if (isNaN(age) || (age < 1)){
        $("#valiage").show()
        flag = true
    }else {
        $("#valiage").hide()
    }
    if (salary === ""){
        $("#salary1").show()
        flag = true;
    }else {
        $("#salary1").hide()
    }
    if (isNaN(salary) || (salary < 1)){
        $("#valisalary").show()
        flag = true
    }else {
        $("#valisalary").hide()
    }
    if (!flag){
        let newEmployee = {
            code: code,
            name: name,
            age: age,
            salary: salary,
            branch: {
                id: branch
            },
        }
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            url: "http://localhost:8080/employees",
            data: JSON.stringify(newEmployee),
            dataType: "text",
            success: function () {
                Swal.fire('Successfully!', '', 'success')
            },
            error: function (){
                alert("duplicate code")
            }
        })
        $(".hide").hide()
    }
        event.preventDefault();

}

function deleteEmployee(id) {
    Swal.fire({
        title: 'Are you sure you want to delete this employee?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                type: "DELETE",
                url: "http://localhost:8080/employees/" + id,
                success: function () {
                    getAllEmployee()

                }
            })
            Swal.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
            )

        }
    })
}

let idUpdate;
let idEdit = '';
function getDataInUpdateForm() {
    let id1 = window.localStorage.getItem("idUpdate1")
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employees/" + id1,
        success: function (data) {
            getBranch()
            $("#code").val(data.code)
            $("#name").val(data.name)
            $("#age").val(data.age)
            $("#salary").val(data.salary)
            $("#branch").val(data.branch.id)
            idEdit = data.id;
        }
    });
}

function updateEmployee() {
    let code = $("#code").val()
    let name = $("#name").val()
    let age = $("#age").val()
    let salary = $("#salary").val()
    let branch = $("#branch").val()
    let flag = false;
    if (code === ""){
        $("#code1").show()
        flag = true;
    }else {
        $("#code1").hide()
    }
    if (name === ""){
        $("#name1").show()
        flag = true;
    }else {
        $("#name1").hide()
    }
    if (age === ""){
        $("#age1").show()
        flag = true;
    }else {
        $("#age1").hide()
    }
    if (isNaN(age) || (age < 1)){
        $("#valiage").show()
        flag = true
    }else {
        $("#valiage").hide()
    }
    if (salary === ""){
        $("#salary1").show()
        flag = true;
    }else {
        $("#salary1").hide()
    }
    if (isNaN(salary) || (salary < 1)){
        $("#valisalary").show()
        flag = true
    }else {
        $("#valisalary").hide()
    }
    if (!flag) {
        let newEmployee = {
            id: idEdit,
            code: code,
            name: name,
            age: age,
            salary: salary,
            branch: {
                id: branch
            },
        }
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "PUT",
            url: "http://localhost:8080/employees/" + idEdit,
            data: JSON.stringify(newEmployee),
            dataType: "text",
            success: function () {
                Swal.fire('Successfully!', '', 'success')
            },
            error: function (){
                alert("duplicate code")
            }
        })
    }
    event.preventDefault();
}

function sort(){
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "GET",
        url: "http://localhost:8080/employees/sort",
        success: function (data) {
            let contentIndex = `<table class="table table-striped"><tr>
                            <th>EmployeeCode</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Salary</th>
                            <th>Department</th>
                            <th>Action</th>
                            <th></th>
                            </tr>`;
            for (let i = 0; i < data.length; i++) {
                contentIndex += `<tr class="paging">`
                contentIndex += displayEmployee(data[i])
                contentIndex += `</tr>`
            }
            // window.localStorage.setItem("branch", JSON.stringify(data[1]));
            contentIndex += `</table>`
            $("#employee-list").html(contentIndex);
        }
    })
    event.preventDefault();
}