package br.com.ekom.websocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekom.websocket.entity.Canal;
import br.com.ekom.websocket.repository.CanalRepository;

@Service
public class CanalService {
	@Autowired 
	CanalRepository canalRepository;
	
	public List<Canal> findAll(){
		return canalRepository.findAll();
	}
	
}
