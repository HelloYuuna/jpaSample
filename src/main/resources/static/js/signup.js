$(document).ready(function() {
    $('#submut-button').on('click', idchk);

});

function submitFalse() {
    return false;
}

// 아이디 중복체크
function idchk() {
    let email = $('#email').val();
    console.log(email);

    $.ajax({
        url:'idcheck' ,
        type: 'post',
        data: { email:email } ,
        success: function(result) {
            console.log(result);

            // true: 아이디존재 -> 중복
            if(result) {
                $('#idchk-msg').html('해당 아이디는 이미 존재합니다.')
                    .select();
            }

        } ,
        error: function(e) {
            JSON.stringify(e);
        }
    });
}

// 회원정보를 넣는 폼