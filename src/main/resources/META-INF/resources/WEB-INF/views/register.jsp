<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Register form">
    <meta name="author" content="Radosław Paradecki">
    <title>Please sign up</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
    <form class="form-signin" id="signupForm" method="post" action="/register">
        <h2 class="form-signup-heading">Please sign up</h2>
        <p>
            <label for="name" class="sr-only">First name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="First name" required
                   autofocus>
        </p>
        <p>
            <label for="surname" class="sr-only">Last name</label>
            <input type="text" id="surname" name="surname" class="form-control" placeholder="Last name" required>
        </p>
        <p>
            <label for="email" class="sr-only">Email</label>
            <input type="text" id="email" name="email" class="form-control" placeholder="Email" required>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <!-- <p>
            <label for="confirmPassword" class="sr-only">Confirm password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm password" oninput="check(this)" required>
        </p> -->
        <button class="btn btn-lg btn-primary btn-block" id="btnSubmit" type="submit">Sign up</button>
    </form>
</div>
</body>
</html>