package com.learning.crud.controller.rest;

import com.learning.crud.model.Role;
import com.learning.crud.model.User;
import com.learning.crud.model.dto.RoleDTO;
import com.learning.crud.model.dto.UserDTO;
import com.learning.crud.service.RoleService;
import com.learning.crud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class LoginRestController {
    private final Logger logger = LoggerFactory.getLogger(LoginRestController.class);
    private final UserService userService;
    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    public LoginRestController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public RedirectView register(@RequestBody UserDTO userDTO) {
        logger.info("Looking for user by username: " + userDTO.getUsername() + " in LoginRestController");
        Optional<User> userFromDb = userService.findUserByUsername(userDTO.getUsername());
        if (userFromDb.isPresent()) {
            logger.info("User found in LoginRestController. User: " + userFromDb);
            // Возвращаем ошибку, так как пользователь существует
            return new RedirectView("/login");
        }

        // Установка выбранных ролей пользователя
        List<String> selectedRoles = userDTO.getRoleNames();
        Set<Role> roles = new HashSet<>();
        for(String role : selectedRoles){
            Optional<Role> roleFromDb = roleService.findRoleByName(role);
            if(roleFromDb.isPresent()){
                roles.add(roleFromDb.get());
            } else {
                logger.info("Role not found in LoginRestController. Role: " + role);
                // Возвращаем ошибку, так как роль не найдена
                return new RedirectView("/login");
            }
        }

        User newUser = new User(null,
                userDTO.getName(),
                userDTO.getUsername(),
                passwordEncoder.encode(userDTO.getPassword()),
                roles,
                userDTO.getStatus(),
                userDTO.getProject(),
                List.of()
                );

        // Сохранение нового пользователя
        userService.saveUser(newUser);

        logger.info("User registered in LoginRestController. User: " + userDTO);
        // Перенаправляем пользователя на страницу "/task" после успешной регистрации
        return new RedirectView("/login");
    }


}
