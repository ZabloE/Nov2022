package lv.venta.demo.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lv.venta.demo.models.PievienoPakalpojumu;

@Repository
public interface IPievienoPakalpojumuRepo extends CrudRepository<PievienoPakalpojumu, Long> {

}
