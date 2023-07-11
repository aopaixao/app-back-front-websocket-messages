package br.com.ekom.websocket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekom.websocket.dto.PromocaoDTO;
import br.com.ekom.websocket.entity.Canal;
import br.com.ekom.websocket.entity.Promocao;
import br.com.ekom.websocket.repository.CanalRepository;
import br.com.ekom.websocket.repository.PromocaoRepository;
import jakarta.transaction.Transactional;

@Service
public class PromocaoService {
	@Autowired 
	PromocaoRepository promocaoRepository;
	
	@Autowired 
	CanalRepository canalRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<Promocao> findAll(){
		return promocaoRepository.findAll();
	}
	
	@Transactional
	public List<PromocaoDTO> getB2CPromocao() {
		Canal canal = canalRepository.findByNomeCanal("B2C");
		List<Promocao> promocoes = new ArrayList<>();
		if(null != canal)
			promocoes = promocaoRepository.findAllByCanais(canal);
		
		return promocoes.stream()
				.map(promocao -> mapper.map(promocao, PromocaoDTO.class))
				.collect(Collectors.toList());		
		
	}
	
	public List<Promocao> getB2BPromocao() {
		Canal canal = canalRepository.findByNomeCanal("B2B");
		List<Promocao> promocoes = new ArrayList<>();
		if(null != canal)
			promocoes = promocaoRepository.findAllByCanais(canal);
		
		return promocoes;
	}
	
}
