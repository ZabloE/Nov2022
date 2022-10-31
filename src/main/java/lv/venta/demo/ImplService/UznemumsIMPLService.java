package lv.venta.demo.ImplService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.User;
import lv.venta.demo.models.Uznemums;
import lv.venta.demo.repos.IUserRepo;
import lv.venta.demo.repos.IUznemumsRepo;
import lv.venta.demo.services.UznemumsService;

@Service
public class UznemumsIMPLService implements UznemumsService{

	@Autowired
	private IUznemumsRepo uznemumsRepo;
	
	
	@Override
	public void createUznemums(String name, String adrese,User user) {
		Uznemums uznemums = new Uznemums(name,adrese, user);
		if(user == null) {
			
			System.out.print("aaaaaaa");
		}
		uznemumsRepo.save(uznemums);
	}

	
	
}
