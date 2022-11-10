package lv.venta.demo.controllers;


import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lv.venta.demo.models.User;
import lv.venta.demo.models.Uznemums;
import lv.venta.demo.repos.IUserRepo;
import lv.venta.demo.repos.IUznemumsRepo;
import lv.venta.demo.services.UznemumsService;

@Controller
public class UznemumsController {

	@Autowired
	private IUznemumsRepo uznemumsRepo;
	
	@Autowired
	private UznemumsService uznemumsService;
	
	@Autowired
	private IUserRepo userRepo;
	
	
	@GetMapping("/pievienoUznemumu")
	public String pievienotUznemumu(Model model , Uznemums uznemums, Principal principal)
	{
		//String username = principal.getName();
	
		Long id = userRepo.findByEmail(principal.getName()).getIdUser();
		model.addAttribute("user", id);
		
		
		
		return "pievienoUznemumu";
	}
	
	
	
	
	@PostMapping("/pievienoUznemumu")
	public  String saveUznemums(Model model, Principal principal,  String name, String adrese, Long idUser)
	{
	
		Uznemums uz = new Uznemums();
		uz.setName(name);
		uz.setAdrese(adrese);
		Long id = userRepo.findByEmail(principal.getName()).getIdUser();
		model.addAttribute("user", id);
		idUser = id;
		uz.setIdUser(idUser);

		//uznemumsRepo.insertUznemums(uz.getId_uznemums(),name, adrese, id);
		uznemumsRepo.save(uz);
		return "savePievPakalpojumu";
	}
	
	 
}



