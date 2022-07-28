package edu.unicesumar.escoladeti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicesumar.escoladeti.domain.Curso;
import edu.unicesumar.escoladeti.service.CursoService;

@RestController
@RequestMapping("curso")
public class CursoController {

	
	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public ResponseEntity<Curso> salvar(@RequestBody Curso curso) {
		return ResponseEntity.ok(cursoService.salvarCurso(curso));
	}
	
	@GetMapping
	public ResponseEntity<Page<Curso>> obterCursosPaginado(Pageable pageable) {
		return ResponseEntity.ok(cursoService.buscarCursos(pageable));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Curso> alterar(@PathVariable Long id, @RequestBody Curso curso) {
		return ResponseEntity.ok(cursoService.alterarCurso(curso));
	}
	
	@DeleteMapping("{id}")
	public void excluirPeloId(@PathVariable Long id) {
		cursoService.excluirCursoPeloId(id);
	}
	
}
