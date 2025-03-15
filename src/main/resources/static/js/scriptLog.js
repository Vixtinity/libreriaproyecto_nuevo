function validateLogin(event) {
  event.preventDefault(); // Prevenir el envío del formulario para manejar la validación con JavaScript

  // Obtener los valores del formulario
  const username = document.getElementById('nombre').value;
  const password = document.getElementById('password').value;

  // Validación básica (esto debería ser reemplazado por una verificación real de la base de datos)
  const validUsers = [
    { username: 'admin', password: 'admin', rol: 'admin' },
    { username: 'user', password: 'admin', rol: 'user' }
  ];

  // Buscar el usuario en la lista de usuarios válidos
  const user = validUsers.find(user => user.username === username && user.password === password);

  // Verificar si el usuario existe y si su rol es "admin"
  if (user) {
      if (user.rol === 'admin') {
          // Si el rol es admin, redirigir a la página de administración
          window.location.href = '/admin'; // Cambia esto a la URL de tu página de administración
  }
}
}
