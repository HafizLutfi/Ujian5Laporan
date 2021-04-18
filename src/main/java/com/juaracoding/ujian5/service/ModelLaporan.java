package com.juaracoding.ujian5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juaracoding.ujian5.entity.Laporan;
import com.juaracoding.ujian5.respository.LaporanRespository;

@Service
public class ModelLaporan implements ModelLaporanInterface {

	@Autowired
	LaporanRespository laporanrespo;
	@Override
	public List<Laporan> getAllLaporan() {
		// TODO Auto-generated method stub
		
		return (List<Laporan>) this.laporanrespo.findAll();
	}

	@Override
	public Laporan getLaporanById(String id) {
		// TODO Auto-generated method stub
		return ((Laporan) this.laporanrespo.findByIdLaporan(Long.parseLong(id)));
	}

	@Override
	public Laporan addLaporan(Laporan laporan) {
		// TODO Auto-generated method stub
		return this.laporanrespo.save(laporan);
	}

	@Override
	public Laporan getLaporanByName(String nama) {
		// TODO Auto-generated method stub
		return this.laporanrespo.findByNamaLaporan(nama);
	}

	@Override
	public void deleteLaporan(String id) {
		// TODO Auto-generated method stub
		this.laporanrespo.deleteById(Long.parseLong(id));
	}


	@Override
	public void setStatusApproved(String Id) {
		// TODO Auto-generated method stub
		this.laporanrespo.setStatus("APPROVED",Id);
	}
	

	@Override
	public void setStatusReject(String Id) {
		// TODO Auto-generated method stub
		this.laporanrespo.setStatus("REJECT",Id);
	}
}
