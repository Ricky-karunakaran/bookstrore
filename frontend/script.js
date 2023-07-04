  // your custom ajax request here
  function getAll(params) {
    var url = 'http://localhost:8080/books'
    $.get(url).then(function (res) {
        params.success(res);
    })

  }

  
function view_book(data){
    console.log("View");
    console.log(data);
}

function delete_book(data){
    console.log("Delete");
    console.log(data);
}