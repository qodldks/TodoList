function dataSend(){
    var data = {
        content : $('#input-data').val(),
        completed : false
    }

    $.ajax({
        type: 'POST',
        url: '/todo/api',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function(){
        window.location.href='/';
    }).fail(function(error){
        alert(JSON.stringify(error));
    });
}