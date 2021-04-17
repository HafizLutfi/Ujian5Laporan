package com.juaracoding.ujian5.respository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.juaracoding.ujian5.entity.Laporan;


public interface LaporanRespository extends CrudRepository<Laporan, Long>{

	Laporan findByIdLaporan(long id);

	Laporan findByNamaLaporan(String nama);

	
	@Query("select count(*) from laporan l where l.status IS NULL")
	Laporan countKosong();
	
	@Query("select count(*) from laporan l where l.status IS NOT NULL")
	Laporan countTerisi();
	

	@Modifying
	@Query(value = "update laporan l set l.status = :status where l.id_laporan= :Id")
	void setStatus(@Param("status") String status, @Param("Id") Long Id);

}
