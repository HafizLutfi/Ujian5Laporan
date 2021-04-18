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

	
	@Query(value="select count(*) from laporan where laporan.status IS NULL",nativeQuery = true)
	long countKosong();
	
	@Query(value="select count(*) from laporan where laporan.status IS NOT NULL",nativeQuery = true)
	long countIsi();
	

	@Modifying
	@Query(value = "update laporan set laporan.status = :status where laporan.id_laporan= :Id",nativeQuery = true)
	void setStatus(@Param("status") String status, @Param("Id") String Id);

}
