package br.com.testeubots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testeubots.model.Solicitation;
import br.com.testeubots.queue.SolicitationSender;
import br.com.testeubots.util.Constants;

@RestController
@RequestMapping("/")
public class SolicitationController {

    @Autowired
    private SolicitationSender solicitationSender;

    @PostMapping("/sendSolicitation")
    public ResponseEntity<?> sendSolicitation(@RequestBody Solicitation solicitation) {
    	
    	if(Constants.CARDS.equals(solicitation.content())) {
    		solicitationSender.sendSolicitationToTeamCards(solicitation);
    	}else if(Constants.LOAN.equals(solicitation.content())) {
    		solicitationSender.sendSolicitationToTeamLoan(solicitation);
    	}else {
    		solicitationSender.sendSolicitationToTeamOthersSubjects(solicitation);
    	}
    	
        return ResponseEntity.ok().build();
    }

}