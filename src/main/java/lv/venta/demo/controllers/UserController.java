package lv.venta.demo.controllers;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lv.venta.demo.models.User;
import lv.venta.demo.services.UznemumsService;

@Controller
public class UserController {

	@Autowired
	private UznemumsService uznemumsService;
	
	@GetMapping("/login")
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
