package lv.venta.demo.ImplService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.PievienoPakalpojumu;

import lv.venta.demo.repos.IPievienoPakalpojumuRepo;
import lv.venta.demo.services.PievienoPakalpojumuService;
@Service
public class PievienoPakalpojumuIMPLService implements PievienoPakalpojumuService{

	@Autowired
	IPievienoPakalpojumuRepo pakalpojumuRepo;
	@Override
	public void createUznemums(String name,  Double laiks) {
		PievienoPakalpojumu pievienoPakalpojumu = new PievienoPakalpojumu(name,laiks);
		pakalpojumuRepo.save(pievienoPakalpojumu);
		
	}

}
