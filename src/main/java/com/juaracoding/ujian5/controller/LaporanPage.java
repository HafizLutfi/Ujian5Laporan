package com.juaracoding.ujian5.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.juaracoding.ujian5.entity.Laporan;
import com.juaracoding.ujian5.service.ModelLaporan;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class LaporanPage {

	private static final String UPLOAD_DIR = null;
	@Autowired
	ModelLaporan modelLaporan;
	
	@GetMapping("/laporan/view")
	public String viewLaporanPage(Model model) {
		model.addAttribute("listlaporan",modelLaporan.getAllLaporan());
		return "view_laporan";
	}
	@GetMapping("/laporan/add")
	public String viewaddLaporanPage(Model model) {
		model.addAttribute("laporan", new Laporan());
		return "add_laporan";
	}
	@PostMapping("/laporan/view")
	public String addLaporan(@RequestParam(value = "file")MultipartFile file,@ModelAttribute Laporan laporan, Model model) {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println(file.getOriginalFilename());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        laporan.setFoto("/uploads/" + fileName);
        this.modelLaporan.addLaporan(laporan);

		model.addAttribute("listlaporan",modelLaporan.getAllLaporan());
		return "redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/update/{id}")
	public String updateLaporan(@PathVariable String id, Model model) {
		
		Laporan laporan = this.modelLaporan.getLaporanById(id);
		model.addAttribute("laporan",laporan);
		return "add_laporan";
	}
	
	@GetMapping("/laporan/delete/{id}")
	public String deleteLaporan(@PathVariable String id, Model model) {
		
		this.modelLaporan.deleteLaporan(id);
		model.addAttribute("listlaporan",modelLaporan.getAllLaporan());
		return"redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/report/pdf")
	public void exportPDF() {
		try {
		File file = ResourceUtils.getFile("classpath:Laporan_Landscape.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		List<Laporan> lstlaporan = modelLaporan.getAllLaporan();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstlaporan);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy","Juaracoding");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        String path = "H:\\laporan.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        
       
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
				
	}

}
