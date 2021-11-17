package br.com.avaliacoes.testes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avaliacoes.testes.modelo.Associados;


public interface AssociadosRepository extends JpaRepository<Associados, Long>{


	List<Associados> findByNome(String nome);

	List<Associados> findAll();

	Page<Associados> findByCargo(String cargo, Pageable paginacao);

	Optional<Associados> findByCargo(String cargo);

}
