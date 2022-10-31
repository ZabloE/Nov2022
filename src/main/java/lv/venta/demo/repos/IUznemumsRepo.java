package lv.venta.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.venta.demo.models.Uznemums;


@Repository
public interface IUznemumsRepo extends CrudRepository<Uznemums, Long>{

		//@Modifying
	//@Query(
	 // value = 
	 //   "insert into Uznemums (name, adrese) values (:name, :adrese)",
	//  nativeQuery = true)
	//void insertUznemums(@Param("name")String name, @Param("adrese")String adrese);
}
