  // your custom ajax request here
  function getAll(params) {
    var url = 'http://localhost:8080/books'
    $.get(url).then(function (res) {
        params.success(res);
    })

  }

  
function view_book(data){
    var book = JSON.parse(data);
    window.location.href = "update_book.html?id="+book.id
}

function delete_book(data){
    console.log("Delete");
    console.log(data);
}