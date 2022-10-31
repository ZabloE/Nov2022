package lv.venta.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lv.venta.demo.models.PievienoPakalpojumu;

@Repository
public interface IPievienoPakalpojumuRepo extends JpaRepository<PievienoPakalpojumu, Long> {

}
