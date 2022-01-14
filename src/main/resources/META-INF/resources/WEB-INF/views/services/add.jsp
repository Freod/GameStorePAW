<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add service</title>
</head>
<body>
<div class="container">
    <form class="form-signin" id="signupForm" method="post" action="/register">
        <h2 class="form-signup-heading">Add game</h2>
        <p>
            <label for="title">Title</label>
            <input type="text" id="title" name="title" class="form-control" placeholder="Title" required>
        </p>
        <p>
            <label for="description">Description</label>
            <input type="text" id="description" name="description" class="form-control" placeholder="Description" required>
        </p>
        <p>
            <label for="packageNumber">Package number</label>
            <input type="text" id="packageNumber" name="packageNumber" class="form-control" placeholder="Package number" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" id="btnSubmit" type="submit">Sign up</button>
    </form>
</div>
</body>
</html>