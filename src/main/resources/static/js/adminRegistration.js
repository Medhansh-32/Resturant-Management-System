document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('#registerForm'); // Use form ID

    form.addEventListener('submit', async function(event) {
        event.preventDefault(); // Prevent form from submitting the traditional way


        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;


        if (password !== confirmPassword) {
            alert('Passwords do not match!');
            return;
        }

        const adminData = {
            adminName: `${firstName} ${lastName}`, // Combining first and last name
            adminEmail: email,
            adminPassword: password,
            phoneNumber: phone
        };

        try {
            const response = await fetch('/admin/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(adminData)
            });

            if (response.ok) {
                alert('Registration successful!');
                window.location.href = '/login'; // Redirect to login page
            } else {
                console.log(await response.text())
                alert('Registration failed: ' + ('Please try again'));
            }
        } catch (error) {
            console.error('Error:', error);
            alert('An error occurred during registration. Please try again.');
        }
    });
});
