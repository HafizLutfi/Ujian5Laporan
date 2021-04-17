package com.juaracoding.ujian5.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String username;
	private String password;
	private String role;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	 @JoinColumn(name="id_user", referencedColumnName = "idUser")
//    private List<Laporan> lstLaporan = new ArrayList<Laporan>();
}
