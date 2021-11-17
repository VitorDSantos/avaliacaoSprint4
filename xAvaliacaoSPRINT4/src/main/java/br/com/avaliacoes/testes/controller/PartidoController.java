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

import br.com.avaliacoes.testes.controller.form.PartidoForm;
import br.com.avaliacoes.testes.controllerDto.DetalhesPartidoDto;
import br.com.avaliacoes.testes.controllerDto.PartidoDto;
import br.com.avaliacoes.testes.modelo.Partidos;
import br.com.avaliacoes.testes.repository.PartidosRepository;
@RestController
@RequestMapping("/avaliacao")
public class PartidoController {
	
	@Autowired
	private  PartidosRepository partidosRepository;

	@GetMapping("/partidos")
	public List<PartidoDto> lista(String nomePartidos){
		
		if(nomePartidos == null) {
			List<Partidos> partidos;
			
				partidos = partidosRepository.findAll();
			
			return PartidoDto.converter(partidos);
		}else {
			List<Partidos> partidos = partidosRepository.findByNomePartidos(nomePartidos);
		
			return PartidoDto.converter(partidos);
		}
	}
	
	@PostMapping("/partidos")
	public ResponseEntity<PartidoDto> cadastrar(@RequestBody @Valid PartidoForm form, UriComponentsBuilder uriBuilder) {
	
		Partidos partidos = form.converter();
		partidosRepository.save(partidos);
	
		URI uri = uriBuilder.path("partidos/{id}").buildAndExpand(partidos.getId()).toUri() ;
		
		return ResponseEntity.created(uri).body(new PartidoDto(partidos));
	}
	
	@GetMapping("/partidos/{id}")
	@Transactional

	public ResponseEntity<DetalhesPartidoDto> detalhar(@PathVariable Long id) {

		Optional<Partidos> partidos = partidosRepository.findById(id);
		if(partidos.isPresent()) {
		return  ResponseEntity.ok(new DetalhesPartidoDto(partidos.get()));
		}else {
			return ResponseEntity.notFound().build();
			 }
	}
//************************************************/**********************************************

	@GetMapping("/partidos/ideologia")
	@Cacheable(value = "lista" )

	public Page<PartidoDto> lista(@RequestParam(required = false) String nomePartido,
			@PageableDefault(sort = "ideologia",direction = Direction.ASC,page = 0, size = 10) Pageable paginacao ){

		if(nomePartido == null) {		
			Page<Partidos> partidos = partidosRepository.findAll(paginacao);
			return PartidoDto.converterPage(partidos);
		}else {
			Page<Partidos> partidos = partidosRepository.findByNomePartidos(nomePartido,paginacao);
			return PartidoDto.converterPage(partidos);
		}
	}
	
//************************************************/**********************************************

	@PutMapping("/partidos/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id,@RequestBody @Valid PartidoForm form){
		Optional<Partidos> opcional = partidosRepository.findById(id);
		if(opcional.isPresent()) {
			Partidos partidos = form.atualizar(id,partidosRepository);
			return ResponseEntity.ok(new PartidoDto(partidos));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/partidos/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Partidos> opcional = partidosRepository.findById(id);
		if(opcional.isPresent()) {
			partidosRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
}
	}
