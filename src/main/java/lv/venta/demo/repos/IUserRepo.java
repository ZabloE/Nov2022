package lv.venta.demo.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.demo.models.User;

@Repository
public interface IUserRepo extends CrudRepository<User, Long>{

	User findByEmail(String email);
	User findByIdUser(Long idUser);
	//User readById(id);
}
