<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home CD Catalog User Registration</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- javascript -->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- local -->
    <link rel="stylesheet" href="../../../pub/css/registration.css">

</head>
<body class="vh-200">
<!-- one section to rule them all . kludge in the view height to 200 to allow for the errors to show up -->
<section class="gradient-custom">
    <div class="container py-5 h-100">
        <!-- Use the bootstrap semantics  each field is assigned a row, each row centered ,
        max two items per row so each item in a row set to col-6 or col-12 -->
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <!-- set a nice border shadow and round the edges of the card -->
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <!-- Set a nice image at the top -->
                    <img src="../../../pub/img/troy-music-hall-blog-video.jpeg" class="w-100 card-img-top" alt="Music Hall">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration</h3>
                        <!-- Start my form .   Use the bootstrap sematics for form validation this gives the nice red
                        green outline on submit validation. Note this validates every field in the form for empty/not empty -->
                        <form class="needs-validation" novalidate id="registerForm">
                            <!-- row #1 with first_name and last_name each place in 1/2 of the card with a bootstrtrap bottom margin (mb-4)-->
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="firstName" class="form-control form-control-sm" required/>
                                        <label class="form-label" for="firstName">First Name</label>
                                        <div id="validationfirstNameFeedback" class="invalid-feedback">
                                            Please enter a First Name
                                        </div>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="lastName" class="form-control form-control-sm" required/>
                                        <label class="form-label" for="lastName">Last Name</label>
                                        <div id="validationlastNameFeedback" class="invalid-feedback">
                                            Please enter a Last Name
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- row #2 with password and confirm password -->
                            <div class="row">
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="password" id="password" class="form-control form-control-sm" required/>
                                        <label class="form-label" for="password">Password</label>
                                        <div id="validationPasswordFeedback" class="invalid-feedback">
                                            Invalid Password : Must contain one Uppercase,  one Lower Case One digit, One special char
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline">
                                        <input type="password" id="confirmPassword" class="form-control form-control-sm"
                                               onkeyup='check();' required/>
                                        <label class="form-label" for="confirmPassword">Confirm Password</label>
                                    </div>
                                </div>
                            </div>

                            <!-- row #3 with UserName  Input type userName-->
                            <div class="row">
                                <div class="col-md-6 mb-2 pb-2">
                                    <div class="form-outline" has-validation>
                                        <input type="text" id="userName" class="form-control form-control-sm" required/>
                                        <label class="userName" for="userName">userName</label>
                                        <div id="validationuserNameFeedback" class="invalid-feedback">
                                            Please choose a valid UserName
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- row #4 . Radio button to control user type  Admin or User.  Use for DB GRANT -->
                            <div class="row">
                                <div class="col-md-12 mb-4">
                                    <h6 class="mb-2 pb-1">User Type: </h6>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                               id="admin" value="option1"
                                        />
                                        <label class="form-check-label" for="admin">Admin</label>
                                    </div>

                                    <div class="form-check form-check-inline">
                                        <input
                                                class="form-check-input" type="radio" name="inlineRadioOptions"
                                                id="user" value="option2" checked />
                                        <label class="form-check-label" for="user">User</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                    </div>
                                </div>
                            </div>

                            <!-- row #5 .  Drop down menu for User music preference. -->
                            <!-- This started life as a sba requirement  But I've come to like it -->
                            <div class="row">
                                <div class="col-12">
                                    <select class="select form-control-md">
                                        <option value="1" disabled>Choose option</option>
                                        <option value="2">Classical</option>
                                        <option value="3">Jazz</option>
                                        <option value="4">Electronic</option>
                                    </select>
                                    <label class="form-label select-label">Choose Primary Music Genre</label>
                                </div>
                            </div>

                            <!-- Row #6 the Submit button. Use bootstrap to make the button an outline with blue color  -->
                            <!-- This row is divided 3 3 6  : 3 for SUbmit button ; 3 blank space ; 6 Message to the user -->
                            <div class="row">
                                <div class="col-md-3 mt-4 pt-2">
                                    <input class="btn btn-outline-primary btn-md" type="submit" value="Submit" />
                                </div>
                                <div class="col-md-3 mt-4 pt-2">
                                </div>
                                <div class="col-md-6 mt-4 pt-2" id="message">Welcome to the Home CD catalog</div>
                            </div>

                            <!-- DIV SOUP  -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>


<script>

    var check = function() {
        if (document.getElementById('password').value ==
            document.getElementById('confirmPassword').value) {
            document.getElementById('message').style.color = 'green';
            document.getElementById('message').innerHTML = 'Password confirmed';
        } else {
            document.getElementById('message').style.color = 'red';
            document.getElementById('message').innerHTML = 'Password does not match';
        }
    }

</script>
<script src="../js/register.js"></script>
</html>