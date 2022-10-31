package lv.venta.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lv.venta.demo.models.User;
import lv.venta.demo.models.Uznemums;
import lv.venta.demo.repos.IUznemumsRepo;

@Controller
public class UznemumsController {

	@Autowired
	private IUznemumsRepo iUznemumsRepo;
	
	
	@GetMapping("/pievienoUznemumu")
	public String pievienotUznemumu(Uznemums uznemums)
	{
		return "pievienoUznemumu";
	}
	
	@PostMapping("/pievienoUznemumu")
	public  String saveUznemums(@RequestParam String name, @RequestParam String adrese, User user)
	{
		Uznemums uz = new Uznemums();
		uz.setName(name);
		uz.setAdrese(adrese);
		
		
		iUznemumsRepo.save(uz);
		return "savePievPakalpojumu";
	}
}



