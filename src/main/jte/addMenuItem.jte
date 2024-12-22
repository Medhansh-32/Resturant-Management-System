<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Menu Item - MarkFood Admin</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/addItem.css">
</head>
<body>
<div class="dashboard">
    <div class="header">
        <h1>Add New Menu Item</h1>
        <div class="header-buttons">
            <a href="/admin" class="back-button">
                <i class="fa-solid fa-arrow-left"></i> Back to Dashboard
            </a>
        </div>
    </div>

    <div class="form-container">
        <form id="addItemForm" class="add-item-form" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Item Name *</label>
                <input type="text" id="name" name="name" required>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" rows="4"></textarea>
            </div>
            <div class="form-group">
                <label for="images">Price</label>
                <input type="number" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="images">Images</label>
                <input type="file" id="images" name="images" accept="image/*" multiple>
            </div>

            <button type="submit" class="submit-button">
                <i class="fa-solid fa-plus"></i> Add Item
            </button>
        </form>
    </div>
</div>
<script src="/js/addItem.js"></script>
</body>
</html>