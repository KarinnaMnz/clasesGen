package com.bestogrupo.thebestogrupo.controllers;


import com.bestogrupo.thebestogrupo.models.Tarea;
import com.bestogrupo.thebestogrupo.models.Usuario;
import com.bestogrupo.thebestogrupo.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/get/{id}")
    public Usuario getUsuarioPorId(@PathVariable Long id) {
        return usuarioService.getUsuarioPorId(id);
    }

    @PostMapping("/create/nuevo")
    public void createUsuario(@RequestBody Usuario usuario){
        usuarioService.createUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuarioPorId(@PathVariable Long id){
        usuarioService.deleteUsuarioPorId(id);
    }

    @PutMapping("/update/{id}")
    public void updateUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.updateUsuarioPorId(id, usuario);
    }

    @RequestMapping("/addtarea/{id}")
    public void asignarTarea(@PathVariable Long id, @RequestBody Tarea tarea){
        usuarioService.asignarTarea(id,tarea);
    }
}
