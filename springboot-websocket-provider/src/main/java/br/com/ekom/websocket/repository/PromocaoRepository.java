package br.com.ekom.websocket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ekom.websocket.entity.Canal;
import br.com.ekom.websocket.entity.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {
	List<Promocao> findAllByCanais(Canal canal);
}
