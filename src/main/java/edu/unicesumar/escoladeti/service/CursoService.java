package edu.unicesumar.escoladeti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.unicesumar.escoladeti.domain.Curso;
import edu.unicesumar.escoladeti.repository.CursoRepository;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso salvarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Page<Curso> buscarCursos(Pageable pageable) {
		return cursoRepository.findAll(pageable);
	}
	
	public Curso alterarCurso(Curso curso) {
		if (!cursoRepository.findById(curso.getId()).isPresent())
			throw new RuntimeException("Curso inexistente.");
		return cursoRepository.save(curso);
	}
	
	public void excluirCursoPeloId(Long id) {
		cursoRepository.deleteById(id);
	}
	
}
