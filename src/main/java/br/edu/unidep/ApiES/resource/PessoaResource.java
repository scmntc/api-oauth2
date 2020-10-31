package br.edu.unidep.ApiES.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unidep.ApiES.event.ObjetoCriadoEvent;
import br.edu.unidep.ApiES.model.Pessoa;
import br.edu.unidep.ApiES.repository.PessoaRepository;
import br.edu.unidep.ApiES.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository repositorio;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Pessoa> pessoas = repositorio.findAll();
		return !pessoas.isEmpty() ? ResponseEntity.ok(pessoas) :
			ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa,
			HttpServletResponse response) {
		
		Pessoa pessoaSalva = repositorio.save(pessoa);
		
		publisher.publishEvent(new ObjetoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
		
	}
	
	@GetMapping("/{codigo_pessoa}")
	public ResponseEntity<Pessoa> buscarPeloCodigo(
		   @PathVariable Long codigo_pessoa) {
		Pessoa pessoa = repositorio.findOne(codigo_pessoa);
		if ( pessoa != null) { 
			return ResponseEntity.ok(pessoa);
		} 
		return ResponseEntity.notFound().build();
	
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		repositorio.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody Pessoa pessoa) {
		
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}

}
