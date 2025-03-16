document.addEventListener("DOMContentLoaded", function () {
    // Handling modal form population for books, categories, authors, and users
    document.querySelectorAll("[data-bs-toggle='modal']").forEach(button => {
        button.addEventListener("click", function () {
            const modalId = this.getAttribute("data-bs-target").substring(1); // Remove "#" to get the modal ID
            const modal = document.getElementById(modalId);

            // Handle different modal types based on the modal ID
            if (modalId === "editModal") { // Book edit modal
                document.getElementById("editId").value = this.getAttribute("data-id");
                document.getElementById("editTitulo").value = this.getAttribute("data-titulo");
                document.getElementById("editAutor").value = this.getAttribute("data-autor");
                document.getElementById("editCategoria").value = this.getAttribute("data-categoria");
                document.getElementById("editPrecio").value = this.getAttribute("data-precio");
            } else if (modalId === "editCategoriaModal") { // Category edit modal
                document.getElementById("editCategoriaId").value = this.getAttribute("data-id");
                document.getElementById("editCategoriaNombre").value = this.getAttribute("data-nombre");
            } else if (modalId === "editAutorModal") { // Author edit modal
                document.getElementById("editAutorId").value = this.getAttribute("data-id");
                document.getElementById("editAutorNombre").value = this.getAttribute("data-nombre");
                document.getElementById("editAutorFecha").value = this.getAttribute("data-fechaNacimiento");
                document.getElementById("editAutorNacionalidad").value = this.getAttribute("data-nacionalidad");
            } else if (modalId === "editUsuarioModal") { // User edit modal
                document.getElementById("editUsuarioId").value = this.getAttribute("data-id");
                document.getElementById("editDireccion").value = this.getAttribute("data-direccion");
                document.getElementById("editEmail").value = this.getAttribute("data-email");
                document.getElementById("editNombre").value = this.getAttribute("data-nombre");
                document.getElementById("editPassword").value = this.getAttribute("data-password");
                document.getElementById("editRol").value = this.getAttribute("data-rol");
                document.getElementById("editTelefono").value = this.getAttribute("data-telefono");
            }
        });
    });
});