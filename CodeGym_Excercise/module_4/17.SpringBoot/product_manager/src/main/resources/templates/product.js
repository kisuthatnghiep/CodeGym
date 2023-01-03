function displayProduct(product) {
    return `<td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.category.name}</td>
            <td><img src="${product.img}" alt=""></td>
            <td><button class="btn btn-danger" onclick="deleteProduct(${product.id})">Delete</button></td>
            <td><button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#modalUpdateProduct" onclick="getDataInUpdateForm(${product.id})">Update</button></td>`;
}

let contentIndex = "";

function getAllProduct() {
    $.ajax(
        {
            type: "GET",
            url: "http://localhost:8080/products",
            success: function (a) {
                getAllCategory(a[1]);
                contentIndex = `<table class="table table-striped"><tr>
                                <th>Product No</th>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Category</th>
                                <th>Image</th>
                                <th></th><th></th></tr>`
                for (let i = 0; i < a[0].length; i++) {
                    contentIndex += `<tr class="paging">`
                    contentIndex += `<td>${i + 1}</td>`
                    contentIndex += displayProduct(a[0][i])
                    contentIndex += `</tr>`
                }
                contentIndex += `</table>`
                document.getElementById(`product_list`).innerHTML = contentIndex;
        list = document.getElementsByClassName('paging');
        loadItem();
        }
            }
    );
}
function searchProduct() {
    let s = $("#search").val();
    $.ajax(
        {
            type: "GET",
            url: "http://localhost:8080/products/search?q=" + s,
            success: function (a) {
                getAllCategory(a[1]);
                let content = `<table class="table table-striped"><tr>
                                <th>Product No</th>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Category</th>
                                <th></th><th></th></tr>`
                for (let i = 0; i < a[0].length; i++) {
                    content += `<tr class="paging">`
                    content += `<td>${i + 1}</td>`
                    content += displayProduct(a[0][i])
                    content += `</tr>`
                }
                content += `</table>`
                document.getElementById(`product_list`).innerHTML = content;
                list = document.getElementsByClassName('paging');
                loadItem();
            }
        }
    );
}

function createProduct() {
    let name = $("#name").val()
    let price = $("#price").val()
    let quantity = $("#quantity").val()
    let category = $("#category").val()
    let newProduct = {  
        name: name,
        price: price,
        quantity: quantity,
        category: {
            id: category
        },
        img: ""
    }
    let formData = new FormData();
    formData.append("file", $('#file')[0].files[0])
    formData.append("product", new Blob([JSON.stringify(newProduct)]
        , {type: 'application/json'}))
    $.ajax({
        headers: {
            // 'Accept': 'application/json',
            // 'Content-Type': 'application/json'
        },
        processData: false,
        contentType: false,
        enctype: "multipart/form-data",
        type: "POST",
        url: "http://localhost:8080/products",
        data: formData,
        success: function (data) {
            $("#name").val("")
            $("#price").val("")
            $("#quantity").val("")
            $("#file").val("")
            getAllProduct()
            $('#modalCreateProduct').modal('hide');
            Swal.fire('Successfully!', '', 'success')
        }
    })
    event.preventDefault();
}

function deleteProduct(id) {
    Swal.fire({
        title: 'Are you sure?',
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
                url: "http://localhost:8080/products/" + id,
                success: function () {
                    getAllProduct()

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

function getDataInUpdateForm(id) {
    idUpdate = id
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/products/" + id,
        success: function (data) {
            $("#name_update").val(data.name)
            $("#price_update").val(data.price)
            $("#quantity_update").val(data.quantity)
            $("#category_update").val(data.category.id)
        }
    });
}

function updateProduct(id) {
    let name = $("#name_update").val();
    let price = $("#price_update").val();
    let quantity = $("#quantity_update").val();
    let category = $("#category_update").val();
    let newProduct = {
        id: idUpdate,
        name: name,
        price: price,
        quantity: quantity,
        category: {
            id: category
        },
        img: ""
    }
    let formData = new FormData();
    formData.append("file", $('#file_update')[0].files[0])
    formData.append("product", new Blob([JSON.stringify(newProduct)]
        , {type: 'application/json'}))
    $.ajax({
            headers: {
                // 'Accept': 'application/json',
                // 'Content-Type': 'application/json'
            },
        processData: false,
        contentType: false,
        enctype: "multipart/form-data",
            type: "PUT",
            url: "http://localhost:8080/products/" + id,
            data: formData,
            success: function () {
                getAllProduct()
                $('#modalUpdateProduct').modal('hide');
                Swal.fire('Changed!', '', 'success')
            }
        }
    )
    event.preventDefault();
}

function getAllCategory(category) {
    let content = `<label for="category" class="form-label">Category</label>
                    <select id="category" class="form-select" aria-label="Default select example">`
    for (let i = 0; i < category.length; i++) {
        content += `<option value="${category[i].id}">${category[i].name}</option>`
    }
    content += `</select>`
    document.getElementById("category_list").innerHTML = content;


    let content1 = `<label for="category_update" class="form-label">Category</label>
                    <select id="category_update" class="form-select" aria-label="Default select example">`
    for (let i = 0; i < category.length; i++) {
        content1 += `<option value="${category[i].id}">${category[i].name}</option>`
    }
    content1 += `</select>`
    document.getElementById("category_list1").innerHTML = content1;
}

// pagination
let thisPage = 1;
let limit = 5;
let list = [];

function loadItem() {
    let beginGet = limit * (thisPage - 1);
    let endGet = limit * thisPage - 1;
    for (let i = 0; i < list.length; i++){
        if (i >= beginGet && i <= endGet) {
            list[i].style.display = 'table-row';
        } else {
            list[i].style.display = 'none';
        }
    }
    listPage();
}

function listPage() {
    let count = Math.ceil(list.length / limit);
    document.querySelector('.listPage').innerHTML = '';

    if (thisPage !== 1) {
        let prev = document.createElement('li');
        prev.innerText = 'PREV';
        prev.setAttribute('onclick', "changePage(" + (thisPage - 1) + ")");
        document.querySelector('.listPage').appendChild(prev);
    }

    for ( i = 1; i <= count; i++) {
        let newPage = document.createElement('li');
        newPage.innerText = i;
        if (i === thisPage) {
            newPage.classList.add('active');
        }
        newPage.setAttribute('onclick', "changePage(" + i + ")");
        document.querySelector('.listPage').appendChild(newPage);
    }

    if (thisPage !== count) {
        let next = document.createElement('li');
        next.innerText = 'NEXT';
        next.setAttribute('onclick', "changePage(" + (thisPage + 1) + ")");
        document.querySelector('.listPage').appendChild(next);
    }
}

function changePage(i) {
    thisPage = i;
    loadItem();
}