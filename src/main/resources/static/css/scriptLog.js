function validateLogin(event) {
  event.preventDefault(); // Prevenir el envío del formulario para manejar la validación con JavaScript

  // Obtener los valores del formulario
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  // Validación básica (esto debería ser reemplazado por una verificación real de la base de datos)
  const validUsers = [
    { username: 'admin', password: 'admin123', rol: 'admin' },
    { username: 'user', password: 'user123', rol: 'user' }
  ];

  // Buscar el usuario en la lista de usuarios válidos
  const user = validUsers.find(user => user.username === username && user.password === password);

  // Verificar si el usuario existe y si su rol es "admin"
  if (user) {
      if (user.rol === 'admin') {
          // Si el rol es admin, redirigir a la página de administración
          window.location.href = '/admin-dashboard'; // Cambia esto a la URL de tu página de administración
      } else {
          // Si el rol no es admin, mostrar un mensaje de error o redirigir a otra página
          alert('No tienes acceso a la administración.');
      }
  } else {
      // Si el usuario no es válido, mostrar un mensaje de error
      alert('Usuario o contraseña incorrectos.');
  }
}
