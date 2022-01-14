<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add game</title>
</head>
<body>
<div class="container">
    <form class="form-signin" id="signupForm" method="post" action="/games/add">
        <h2 class="form-signup-heading">Add game</h2>
        <p>
            <label for="name">Name</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Name" required>
        </p>
        <p>
            <label for="platform">Platform</label>
            <input type="text" id="platform" name="platform" class="form-control" placeholder="Platform" required>
        </p>
        <p>
            <label for="price">Price</label>
            <input type="text" id="price" name="price" class="form-control" placeholder="Price" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" id="btnSubmit" type="submit">Sign up</button>
    </form>
</div>
</body>
</html>