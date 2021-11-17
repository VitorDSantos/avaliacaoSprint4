package br.com.avaliacoes.testes.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.avaliacoes.testes.controller.form.AssociadosForm;
import br.com.avaliacoes.testes.controller.form.PartidoForm;
import br.com.avaliacoes.testes.controllerDto.AssociadosDto;
import br.com.avaliacoes.testes.controllerDto.DetalhesAssociadosDto;
import br.com.avaliacoes.testes.controllerDto.DetalhesPartidoDto;
import br.com.avaliacoes.testes.controllerDto.PartidoDto;
import br.com.avaliacoes.testes.modelo.Associados;
import br.com.avaliacoes.testes.modelo.Partidos;
import br.com.avaliacoes.testes.repository.AssociadosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/avaliacao")
@Api(value = "API Partidos e Associados")
@CrossOrigin(origins="*")
public class AssociadosController {
	
	
	@Autowired
	private AssociadosRepository associadosRepository;
	
	
	@GetMapping("/associados")
	public List<AssociadosDto> lista(String nome){
		
		if(nome == null) {
			List<Associados> associados;
			
			associados = associadosRepository.findAll();
			
			return AssociadosDto.converter(associados);
		}else {
			List<Associados> associados = associadosRepository.findByNome(nome);
		
			return AssociadosDto.converter(associados);
		}
	}
	@PostMapping("/associados")
	@ApiOperation(value= "adiciona")
	public ResponseEntity<AssociadosDto> cadastrar(@RequestBody @Valid AssociadosForm form, UriComponentsBuilder uriBuilder) {
	
		Associados associados = form.converter();
		associadosRepository.save(associados);
	
		URI uri = uriBuilder.path("associados/{id}").buildAndExpand(associados.getId()).toUri() ;
		
		return ResponseEntity.created(uri).body(new AssociadosDto(associados));
	}
	@GetMapping("/associados/{id}")
	@Transactional
	@ApiOperation(value= "lista pelo id")

	public ResponseEntity<DetalhesAssociadosDto> detalhar(@PathVariable Long id) {

		Optional<Associados> associados = associadosRepository.findById(id);
		if(associados.isPresent()) {
		return  ResponseEntity.ok(new DetalhesAssociadosDto(associados.get()));
		}else {
			return ResponseEntity.notFound().build();
			 }
	}
	
	@PutMapping("/associados/{id}")
	@Transactional
	@ApiOperation(value= "atualiza")
	public ResponseEntity<AssociadosDto> atualizar(@PathVariable Long id,@RequestBody @Valid AssociadosForm form){
		Optional<Associados> opcional = associadosRepository.findById(id);
		if(opcional.isPresent()) {
			Associados associados = form.atualizar(id,associadosRepository);
			return ResponseEntity.ok(new AssociadosDto(associados));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/associados/{id}")
	@Transactional
	@ApiOperation(value= "Deleta")
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Associados> opcional = associadosRepository.findById(id);
		if(opcional.isPresent()) {
			associadosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
}
}
