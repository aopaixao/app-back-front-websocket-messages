package br.com.ekom.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ekom.websocket.entity.Canal;

public interface CanalRepository extends JpaRepository<Canal, Integer> {
	Canal findByNomeCanal(String nomeCanal);
}
