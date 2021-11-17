package br.com.avaliacoes.testes.repository;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avaliacoes.testes.modelo.Partidos;

public interface PartidosRepository extends JpaRepository<Partidos, Long>{
	List<Partidos> findByNomePartidos(String nomePartidos);

	Page<Partidos> findByNomePartidos(String nomePartidos, Pageable paginacao);


}
