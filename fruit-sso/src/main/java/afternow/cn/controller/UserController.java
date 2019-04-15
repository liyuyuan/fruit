package afternow.cn.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@GetMapping("/images/imagecode")
	public String imagecode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OutputStream outputStream = response.getOutputStream();
		imagecode(request, response);
		return "";
	}

}
