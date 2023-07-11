/**
package br.com.ekom.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.ekom.websocket.service.PromocaoService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner{
	@Autowired
	PromocaoService promocaoService;
	
	@Override
    public void run(String...args) throws Exception {
       System.out.print("Promocoes B2C: " + 
    		   promocaoService.getB2CPromocao().toString());
    }
	
}
/**/