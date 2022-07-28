package edu.unicesumar.escoladeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicesumar.escoladeti.domain.Pessoa;
import edu.unicesumar.escoladeti.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.salvarPessoa(pessoa));
	}
	
	@GetMapping
	public ResponseEntity<Page<Pessoa>> buscarPessoasPaginado(Pageable pageable) {
		return ResponseEntity.ok(pessoaService.buscarPessoas(pageable));
	}
	
	
}
