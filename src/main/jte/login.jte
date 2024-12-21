<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MarkFood Restaurant - Login</title>
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<div class="login-container">
    <div class="logo">
        <h1>MarkFood</h1>
        <p>Taste the Excellence</p>
    </div>
    <form action="/login" method="POST">
        <div class="input-group">
            <label for="username">Username or Email</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="input-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit" class="btn-login">Login</button>
        <div class="links">
            <a href="/register">Create Account</a>
        </div>
    </form>
</div>
</body>
</html>