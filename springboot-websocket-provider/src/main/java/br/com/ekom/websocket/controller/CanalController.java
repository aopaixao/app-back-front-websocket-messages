package br.com.ekom.websocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekom.websocket.entity.Canal;
import br.com.ekom.websocket.service.CanalService;

@RestController
@RequestMapping("/canais")
public class CanalController {
	@Autowired
	CanalService canalService;
	
	public ResponseEntity<List<Canal>> findAll(){
		return new ResponseEntity<>(canalService.findAll(), HttpStatus.OK);
	}
}