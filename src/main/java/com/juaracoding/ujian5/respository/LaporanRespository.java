package com.juaracoding.ujian5.respository;




import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.juaracoding.ujian5.entity.Laporan;

@Repository
public interface LaporanRespository extends CrudRepository<Laporan, Long>{

	Laporan findByIdLaporan(long id);

	Laporan findByNamaLaporan(String nama);

	
	@Query("select count(l) from laporan l where :status is null")
	Laporan countKosong();
	
	@Query("select count(l) from laporan l where :status is not null")
	Laporan countIsi();
	

	@Modifying
	@Query(value = "update laporan l set l.status = :status where l.id_laporan= :Id",nativeQuery = true)
	void setStatus(@Param("status") String status, @Param("Id") long Id);

}
