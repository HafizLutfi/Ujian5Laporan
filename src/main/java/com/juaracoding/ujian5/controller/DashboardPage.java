package com.juaracoding.ujian5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juaracoding.ujian5.respository.LaporanRespository;

@Controller
public class DashboardPage {

	@Autowired
	LaporanRespository laporanRespo;
	
	@GetMapping("/dashboard")
	public String viewDashBoard(Model model) {
		model.addAttribute("jumlahLaporan",laporanRespo.count());
		return "dashboard";
	}
}
