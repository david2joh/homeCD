const psswd = document.getElementById("password");
const confirm = document.getElementById("confirmPassword");
const msg = document.getElementById("message");


$('#registerForm').on("submit", function(event) {
    let passwordTest = (psswd.value === confirm.value);
    if (!passwordTest) {  event.preventDefault(); alert("password and confirm passwords do not match");}
    else {        msg.style.color = 'green';
                  $('#message').text("Registration Successful") ;
    }
})

function validate() {}
// // SBA  loop through an array (well it only has one member but ...)
// function validate() {
//     'use strict'
//     let button = document.QuerySelector("#mySubmitbtn");
//     button.addEventListener("click", validate());
//     // Fetch all the forms we want to apply custom Bootstrap validation styles to
//     let forms = document.querySelectorAll('.needs-validation')
//
//     // Loop over them and prevent submission
//     Array.prototype.slice.call(forms)
//         .forEach(function (form) {
//             form.addEventListener('submit', function (event) {
//                 if (!form.checkValidity()) {
//                     event.preventDefault()
//                     event.stopPropagation()
//                 }
//
//                 form.classList.add('was-validated')
//             }, false)
//         })
// }

const check = () => {
    if (psswd.value == confirmPassword.value) {
        msg.style.color = 'green';
        msg.innerHTML = 'Password/Confirm match';
    } else {
        msg.style.color = 'red';
        msg.innerHTML = 'Password/Confirm do not match';
    }
}
