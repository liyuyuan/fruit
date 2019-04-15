package afternow.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/turbine")
public class TurbineController {
	@RequestMapping("/")
	public String hystrix() {
		return "forward:/hystrix";
	}

}
