package afternow.cn.controller;


import afternow.cn.model.UserAccess;
import afternow.cn.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserAccess userAccess) {
        // Validate and save user access
        userService.saveUserAccess(userAccess);
        return ResponseEntity.ok("Access added successfully");
    }
}
