package lv.venta.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import lv.venta.demo.ImplService.UserImplService;

import lv.venta.demo.web.dto.UserRegistrationDto;


@RequestMapping("/register")
@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserImplService userImplService;
	
	
	@ModelAttribute("user")
	public UserRegistrationDto registrationDto()
	{
		return new UserRegistrationDto();
	}
	
	
	@GetMapping
	public String showRegistrationForm(  UserRegistrationDto registrationDto,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return"error";
		}
		return "register";
	}
	
	
	
	@PostMapping
	public String registerUserAccount( UserRegistrationDto registrationDto)
	{
		userImplService.save(registrationDto);
		return "redirect:/register?success";
	}
	
	
	@GetMapping("/user/register")
	public String showRegistrationForm(WebRequest request, Model model) {
	    UserRegistrationDto userDto = new UserRegistrationDto();
	    model.addAttribute("user", userDto);
	    return "register";
	}
	
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	

	
	
}
