package com.juaracoding.ujian5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juaracoding.ujian5.entity.Laporan;

@Service
public interface ModelLaporanInterface {

	public List<Laporan> getAllLaporan();
	public Laporan getLaporanById(String id);
	public Laporan addLaporan(Laporan laporan);
	public Laporan getLaporanByName(String name);
	public void deleteLaporan(String id);
	void setStatusApproved(String Id);
	void setStatusReject(String Id);
}
