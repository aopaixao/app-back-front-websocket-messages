package br.com.ekom.websocket.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.ekom.websocket.dto.PromocaoDTO;
import br.com.ekom.websocket.service.PromocaoService;
import jakarta.transaction.Transactional;

@Service
public class WebSocketScheduler {
	@Autowired
	PromocaoService promocaoService;
	
	@Autowired
    private SimpMessagingTemplate template;
	
	@Transactional
	@Scheduled(fixedRate = 10000)
	public void sendB2CPromo() {
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    //Date date = new Date();  
		//System.out.println("###################################################");	    
	    //System.out.println(formatter.format(date));  
	    
		List<PromocaoDTO> promocoes = promocaoService.getB2CPromocao();
		//System.out.println(promocoes.toString());
		
		//System.out.println("###################################################");
		this.template.convertAndSend("/b2c/messages", promocoes);
	}
}
