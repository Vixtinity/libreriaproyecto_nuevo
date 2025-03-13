function validateLogin(event) {
    event.preventDefault(); // Evita que el formulario se envíe automáticamente
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (username === 'admin' && password === 'admin') {
        window.location.href = 'productos.html'; // Redirige a productos.html
    } else {
        window.location.href = 'index.html'; // Redirige a index.html si no coincide
    }
}


