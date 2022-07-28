package edu.unicesumar.escoladeti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.unicesumar.escoladeti.domain.Pessoa;
import edu.unicesumar.escoladeti.repository.PessoaRepository;

@Service
@Transactional
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Page<Pessoa> buscarPessoas(Pageable pageable) {
		return pessoaRepository.findAll(pageable);
	}
	
}
