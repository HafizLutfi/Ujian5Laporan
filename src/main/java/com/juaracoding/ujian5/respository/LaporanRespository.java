package com.juaracoding.ujian5.respository;



import org.springframework.data.repository.CrudRepository;

import com.juaracoding.ujian5.entity.Laporan;

public interface LaporanRespository extends CrudRepository<Laporan, Long>{

	Laporan findByIdLaporan(long id);

	Laporan findByNamaLaporan(String nama);

	

}
