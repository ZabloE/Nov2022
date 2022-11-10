package lv.venta.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.venta.demo.models.User;
import lv.venta.demo.models.Uznemums;


@Repository
public interface IUznemumsRepo extends CrudRepository<Uznemums, Long>{

	/*
	
		@Modifying
	@Query(
	  value = 
	    "update Uznemums set name = :name, adrese = :adrese, id_user = :id_user where id_uznemums = :id_uznemums ",
	  nativeQuery = true)
	void insertUznemums(@Param("id_uznemums")Long id_uznemums,@Param("name")String name, @Param("adrese")String adrese,
			@Param("id_user")Long id_user);
	
		@Modifying
		@Query(
		  value = 
		    "insert into Uznemums (id_uznemums,name, adrese,id_user) values (:id_uznemums, null, null, null)",
		  nativeQuery = true)
		void insertUznemumsOne(@Param("id_uznemums")Long id_uznemums);
		
		*/
}
