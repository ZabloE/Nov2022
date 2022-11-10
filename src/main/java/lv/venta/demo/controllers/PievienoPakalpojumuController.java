package lv.venta.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lv.venta.demo.models.PievienoPakalpojumu;

import lv.venta.demo.repos.IPievienoPakalpojumuRepo;

@Controller

public class PievienoPakalpojumuController {

	@Autowired
	private IPievienoPakalpojumuRepo pakalpojumuRepo;
	
	
	
	@GetMapping( "/savePievPakalpojumu")
	public String pievienoPakalpojumu( PievienoPakalpojumu pievienoPakalpojumu )
	{
		
		
		return "savePievPakalpojumu";
	}
	
	@PostMapping("/savePievPakalpojumu")
	public  String savePakalpojums(String name,  Double laiks,PievienoPakalpojumu pievienoPakalpojumu)
	{
		PievienoPakalpojumu piev = new PievienoPakalpojumu();
		piev.setName(name);
		piev.setLaiks(laiks);
		pakalpojumuRepo.save(piev);
	
		return "uznemumsLapa";
	}
	
	
}
