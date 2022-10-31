package lv.venta.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lv.venta.demo.models.PievienoPakalpojumu;

import lv.venta.demo.repos.IPievienoPakalpojumuRepo;

@Controller
public class PievienoPakalpojumuController {

	@Autowired
	private IPievienoPakalpojumuRepo pakalpojumuRepo;
	
	@GetMapping("/savePievPakalpojumu")
	public String pievienoPakalpojumu(PievienoPakalpojumu pakalpojumu)
	{
		return "savePievPakalpojumu";
	}
	
	@PostMapping("/savePievPakalpojumu")
	public  String savePakalpojums(@RequestParam String name, @RequestParam Double laiks)
	{
		PievienoPakalpojumu piev = new PievienoPakalpojumu();
		piev.setName(name);
		piev.setLaiks(laiks);
		pakalpojumuRepo.save(piev);
	
		return "savePievPakalpojumu";
	}
	
	
}
