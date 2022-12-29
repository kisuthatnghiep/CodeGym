function displayCategory(category) {
    return `<td>${category.name}</td>
            <td><button class="btn btn-danger" onclick="deleteCategory(${category.id})">Delete</button></td>
            <td><button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#modalUpdateCategory" onclick="getDataInUpdateForm(${category.id})">Update</button></td>`;
}

function getAllCategory() {
    $.ajax(
        {
            type: "GET",
            url: "http://localhost:8080/category",
            success: function (a) {
                let content = `<table class="table table-striped"><tr>
                                <th>Category No</th>
                                <th>Category Name</th>
                                <th></th><th></th></tr>`
                for (let i = 0; i < a.length; i++) {
                    content += `<tr>`
                    content += `<td>${i + 1}</td>`
                    content += displayCategory(a[i])
                    content += `</tr>`
                }
                content += `</table>`
                document.getElementById(`category_list`).innerHTML = content;
            }
        }
    );
}

function createCategory() {
    let name = $("#name").val()
    let newCategory = {
        name: name
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/category",
        data: JSON.stringify(newCategory),
        dataType: "text",
        success: function (data) {
            document.getElementById("name").value = ""
            getAllCategory()
            $('#modalCreateCategory').modal('hide');
            alert("Create Successfully!")
        }
    })
    event.preventDefault();
}

function deleteCategory(id) {
    if (confirm(`Are you sure want to delete this category?`)) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/category/" + id,
            success: function () {
                getAllCategory()
                alert('Delete successfully')
            }
        })
    }
}

let idUpdate;

function getDataInUpdateForm(id) {
    idUpdate = id
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/category/" + id,
        success: function (data) {
            $("#name_update").val(data.name)
        }
    });
}

function updateCategory(id) {
    let name = $("#name_update").val();
    let newCategory = {
        id: idUpdate,
        name: name
    }
    $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "PUT",
            url: "http://localhost:8080/category/" + id,
            data: JSON.stringify(newCategory),
            dataType: "text",
            success: function (data) {
                getAllCategory()
                $('#modalUpdateCategory').modal('hide');
                alert(data)
            }
        }
    )
    event.preventDefault();
}