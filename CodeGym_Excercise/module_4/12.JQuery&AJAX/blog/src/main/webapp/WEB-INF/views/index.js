function displayBlog(blog){
    return `<td>${blog.name}</td><td>${blog.date}</td>
            <td><button class="btn btn-danger" onclick="deleteBlog(${blog.id})">Delete</button></td>
            <td><button class="btn btn-warning" onclick="">Update</button></td>`;
}

function getAllBlog(){
    $.ajax(
        {
            type: "GET",
            url: "http://localhost:8080/blog",
            success: function (a){
                let content = `<table class="table table-striped"><tr>
                                <th>Blog No</th>
                                <th>Blog Name</th>
                                <th>Date</th><td></td><td></td></tr>`
                for (let i = 0; i < a.length; i++){
                    content += `<tr>`
                    content += `<td>${i + 1}</td>`
                    content += displayBlog(a[i])
                    content += `</tr>`
                }
                content += `</table>`
                document.getElementById(`list`).innerHTML = content;
            }
        }
    );
}

function createBlog() {
    let name = $("#name").val()
    let content = $("#content").val()
    let newBlog = {
        name: name,
        content: content
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/blog",
        data: JSON.stringify(newBlog),
        success: function (data) {
            getAllBlog()
            if (data.name != null) {
                alert("Create Successfully!")
            }
            document.getElementById("name").value = ""
            document.getElementById("content").value = ""
            $('#exampleModalCreate').modal('hide');
        }
    })
    event.preventDefault();
}

function deleteBlog(id){
    if (confirm(`Are you sure want to delete this blog?`)){
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/blog/" + id,
            success: function (){
                getAllBlog()
                alert('Delete successfully')
            }
        })
    }
}

function getDataInUpdateForm(id) {

}