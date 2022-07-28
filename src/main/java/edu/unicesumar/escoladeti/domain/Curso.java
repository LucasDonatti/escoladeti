package edu.unicesumar.escoladeti.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long codigo;
	
	private String nome;
	
	private Integer chMinima;
	
	private Integer chMaxima;
	
	private LocalDate dataAprovacao;
	
}
