document.getElementById('addItemForm').addEventListener('submit', async function(submitEvent) {
    submitEvent.preventDefault();

    const submitButton = document.querySelector('.submit-button');
    const originalButtonText = submitButton.innerHTML;

    try {
        // Show loading state
        submitButton.disabled = true;
        submitButton.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Processing...';

        const imageInput = document.getElementById('images');
        const imageFile = imageInput.files[0];

        let imageUrl = '';

        if (imageFile) {
            const imageFormData = new FormData();
            imageFormData.append('image', imageFile);

            submitButton.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Uploading Image...';

            const imageUploadResponse = await fetch('/image/upload', {
                method: 'POST',
                body: imageFormData
            });

            if (!imageUploadResponse.ok) {
                throw new Error('Image upload failed');
            }

            // Directly get the URL string from response
            imageUrl = await imageUploadResponse.text();
        }

        submitButton.innerHTML = '<i class="fas fa-spinner fa-spin"></i> Saving Item...';

        const formData = new FormData(this);
        if (imageUrl) {
            formData.set('images', imageUrl);

        }
        let foodItem =[
            {
                name:formData.get("name"),
                description:formData.get("description"),
                price:formData.get("price"),
                images:formData.get("images")
            }
        ];
        const response = await fetch('/addItem', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(foodItem)

        });

        if (response.ok) {
            alert('Item added successfully!');
        } else {
            throw new Error('Failed to add item');
        }

    } catch (error) {
        console.error('Error:', error);
        alert(error.message || 'An error occurred. Please try again.');


        submitButton.disabled = false;
        submitButton.innerHTML = originalButtonText;
    } finally {

        if (submitButton.disabled) {
            submitButton.disabled = false;
            submitButton.innerHTML = originalButtonText;
        }
    }
});