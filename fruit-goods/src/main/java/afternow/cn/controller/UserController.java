package afternow.cn.controller;


import afternow.cn.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{resource}")
    public ResponseEntity<?> getUserResource(@PathVariable String resource, Principal principal) {
        long userId = Long.parseLong(principal.getName()); // Assuming username is userId
        if (userService.hasAccess(userId, resource)) {
            return ResponseEntity.ok("Success");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
    }
}