package br.com.ekom.websocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import br.com.ekom.websocket.dto.PromocaoDTO;
import br.com.ekom.websocket.entity.Promocao;
import br.com.ekom.websocket.service.PromocaoService;

@Controller
public class PromocaoController {
	@Autowired
	PromocaoService promocaoService;
	
	@Autowired
    SimpMessagingTemplate simpMessagingTemplate;
	
	//Handles messages from /app/b2c
	@MessageMapping("/b2c")
	// Sends the return value of this method to /topic/messages
	@SendTo("/b2c/messages")
	public List<PromocaoDTO> sendToB2C(final Promocao promocao) throws Exception {
		List<PromocaoDTO> promocoes = promocaoService.getB2CPromocao();
		System.out.print("Promocoes B2C: " + 
				promocoes.toString());
		return promocoes;
	}
	
	@MessageMapping("/b2b")
    @SendTo("/b2b")
    public Promocao sendToB2B(final Promocao promocao) throws Exception {
        return promocao;
    }

    // Mapped as /app/private
    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload Promocao promocao) {
        simpMessagingTemplate
        	.convertAndSendToUser(promocao.getCanais().get(0).getNomeCanal(), 
        			"/specific", promocao);
    }
}