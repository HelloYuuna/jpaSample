$(document).ready(function() {
    $('#email').on('blur', function() {
        let email = $('#email').val();
        console.log(email);

        $.ajax({
            url:'idcheck' ,
            type: 'post',
            data: { email:email } ,
            success: function() {

            } ,
            error: function(e) {
                JSON.stringify(e);
            }
        });

    });
});