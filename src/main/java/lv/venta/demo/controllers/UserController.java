package lv.venta.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserController {

	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/index")
	public String home()
	{
		return "index";
	}
	
}
