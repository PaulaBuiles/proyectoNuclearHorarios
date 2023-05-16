package co.edu.cue.proyectoNuclear.infrastructure.controllers;


import co.edu.cue.proyectoNuclear.domain.entities.Usuario;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/get-all")
    public List<Usuario> getAllUser() {
        return service.getAllUsers();
    }

    @GetMapping("/get-by-name/{name}")
    public String getUserByName(@PathVariable
                        String name) {
        return service.getUserByName(name);
    }
}
