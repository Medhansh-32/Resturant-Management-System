<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MarkFood Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/styleAdmin.css">

</head>
<body>
<div class="dashboard">
    <div class="header">
        <h1>Order Management Dashboard</h1>
        <a href="/addItem" class="add-item-button">
            <i class="fa-solid fa-plus"></i> Add Menu Item
        </a>
        <a href="/logout" class="logout-button">Logout <i class="fa-solid fa-right-from-bracket"></i></a>
    </div>

    <div class="orders-container" id="orders-container">
    </div>
</div>
<script src="/js/adminScript.js"></script>
</body>
</html>