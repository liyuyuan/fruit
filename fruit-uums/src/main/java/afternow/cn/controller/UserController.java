package afternow.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afternow.cn.service.service.UserService;

@RestController
@RequestMapping("/api/vi/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> users(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
	}
	

}
