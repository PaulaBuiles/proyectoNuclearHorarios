package co.edu.cue.proyectoNuclear.infrastructure.controllers;

import co.edu.cue.proyectoNuclear.domain.configuration.Pages;
import co.edu.cue.proyectoNuclear.mapping.dtos.UserLoginDto;
import co.edu.cue.proyectoNuclear.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@RequestMapping("/login") // Mapea esta clase para manejar solicitudes con la ruta "/login".
@AllArgsConstructor // Genera un constructor con parámetros para todos los campos de la clase.
@Controller
public class LoginController {

    private final UserService userService;



    @GetMapping("/")
    public ModelAndView post(){
        // Crea un objeto ModelAndView y lo inicializa con la vista "Pages.LOGIN".
        ModelAndView modelAndView = new ModelAndView(Pages.LOGIN);
        // Agrega un objeto "userLoginDto" al modelo con valores predeterminados de "null" para el campo "identification" y "1" para el campo "password".
        modelAndView.addObject("userLoginDto", new UserLoginDto(null,"1"));
        return modelAndView; // Devuelve el objeto ModelAndView.
    }

    @PostMapping("/start-login")
    public ModelAndView getData(@RequestParam("identification") Long identification, @RequestParam("password") String password) {
        // Crea un objeto UserLoginDto con los parámetros recibidos.
        UserLoginDto userLoginDto = new UserLoginDto(identification, password);
        // Crea un objeto ModelAndView y lo inicializa con la vista "Pages.LOGIN".
        ModelAndView modelAndView = new ModelAndView(Pages.LOGIN);
        if (userService.validateUser(identification, password)) {
            return start(); // Si el usuario es válido, llama al método start() y devuelve su resultado.
        } else {
            // Agrega un mensaje de error y un objeto "userLoginDto" con valores predeterminados al modelo.
            modelAndView.addObject("message", "Credenciales incorrectas");
            modelAndView.addObject("userLoginDto", new UserLoginDto(null,"1"));
            return modelAndView; // Devuelve el objeto ModelAndView.
        }
    }

    @GetMapping("/login-sucessful")
    public ModelAndView start(){
        ModelAndView modelAndView = null;
        // Utiliza una estructura de control switch para determinar el rol del usuario obtenido desde el servicio userService.
        switch (userService.getUser().role()) {
            case "Estudiante" -> {
                // Si el rol es "Estudiante", crea un objeto ModelAndView y lo inicializa con la vista "Pages.STUDENT_HOME".
                // Luego agrega el objeto "user" al modelo con el usuario obtenido del servicio userService.
                modelAndView = new ModelAndView(Pages.STUDENT_HOME);
                modelAndView.addObject("user", userService.getUser());
                return modelAndView; // Devuelve el objeto ModelAndView.
            }
            case "Profesor" -> {
                // Si el rol es "Profesor", crea un objeto ModelAndView y lo inicializa con la vista "Pages.TEACHERHOME".
                // Luego agrega el objeto "user" al modelo con el usuario obtenido del servicio userService.
                modelAndView = new ModelAndView(Pages.TEACHERHOME);
                modelAndView.addObject("user", userService.getUser());
                return modelAndView; // Devuelve el objeto ModelAndView.
            }
            case "Administrativo" -> {
                // Si el rol es "Administrativo", crea un objeto ModelAndView y lo inicializa con la vista "Pages.ADMIN_HOME".
                // Luego agrega el objeto "user" al modelo con el usuario obtenido del servicio userService.
                modelAndView = new ModelAndView(Pages.ADMIN_HOME);
                modelAndView.addObject("user", userService.getUser());
                return modelAndView; // Devuelve el objeto ModelAndView.
            }
        }
        return modelAndView; // Devuelve el objeto ModelAndView (en este caso, será null si no se encuentra un rol válido).
    }
}

