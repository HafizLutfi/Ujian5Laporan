package com.juaracoding.ujian5.service;

import java.util.List;

import com.juaracoding.ujian5.entity.Laporan;

public interface ModelLaporanInterface {

	public List<Laporan> getAllLaporan();
	public Laporan getLaporanById(String id);
	public Laporan addLaporan(Laporan laporan);
	public Laporan getLaporanByName(String name);
	public void deleteLaporan(String id);
}