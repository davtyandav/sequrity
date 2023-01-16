package ru.davtyan.sequrity.spring_sequrity.controlors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.davtyan.sequrity.spring_sequrity.UserValidator;
import ru.davtyan.sequrity.spring_sequrity.dto.registracion.UserDto;
import ru.davtyan.sequrity.spring_sequrity.service.user.UserService;


@RequestMapping("/")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserValidator userValidator;

    @GetMapping("/api/init")
    public String init() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || StringUtils.isEmpty(auth.getName())) {
            return null;
        }
        return "Welcame !";
    }


    @GetMapping("/api/posts/search")
    public String search() {
        return "Welcame ! search ";
    }


    @GetMapping("/api/auth")
    public Long auth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || StringUtils.isEmpty(auth.getName())) {
            return null;
        }
        return userService.fainByName(auth.getName()).getId();
    }

    @PostMapping("/api/registration")
    public void registration(@RequestBody UserDto user) {
        userService.registration(user);
    }
}
