$('#registerForm').on("submit", function(event){
    event.preventDefault();
    let regexPassword = (/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\w\d\s:])([^\s]){3,32}$/)
    let passwordTest = regexPassword.test($('#password').val());
    let confirmPasswordTest =
        regexPassword.test($('#confirmPassword').val());
    // let emailTest = (/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/).test( $('#email').val());
    if (!passwordTest) { alert("password Invalid");}
    // else if (!emailTest) {alert("Invalid Email")}
    else if ($('#password').val() !== $('#confirmPassword').val()) {alert("Passwords do not match")}
    else { $('#message').text("Registration Successful") ;}

    let emailEle = $('#email');
    let passwordEle = $('#password');
    if (emailTest) {
        emailEle.removeClass('is-invalid');
    } else {
        emailEle.addClass('is-invalid');
    }
    if (passwordTest) {
        passwordEle.removeClass('is-invalid');
    } else {
        passwordEle.addClass('is-invalid');
    }

});


// SBA  loop through an array (well it only has one member but ...)
(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
})()
