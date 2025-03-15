package com.libreriaproyecto.libreriaproyecto.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.libreriaproyecto.libreriaproyecto.model.Services.LibroService;
import com.libreriaproyecto.libreriaproyecto.model.Services.UsuarioService;
import com.libreriaproyecto.libreriaproyecto.model.Entities.Usuario;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String getUsuarios(Model modelo) {
        List<Usuario> usuarios = this.usuarioService.getAll();
        modelo.addAttribute("usuarios", usuarios);
        return "/www/usuarios/listar";
    }

        @GetMapping("usuario/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/admin";
    }

    @GetMapping("/usuarios/{id}")
    public String getUsuario(@PathVariable(value="id", required=false) Integer id, Model vista) {
        System.out.println("El usuario es " + id);
        Usuario usuario = this.usuarioService.getId(id);
        System.out.println(usuario);

        vista.addAttribute("usuario", usuario);
        return "/www/usuarios/detalle";
    }
}
