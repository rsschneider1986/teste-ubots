//package br.com.testeubots.queue;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import br.com.testeubots.model.Solicitation;
//import br.com.testeubots.service.ProcessSolicitationService;
//import br.com.testeubots.util.Constants;
//import io.awspring.cloud.sqs.annotation.SqsListener;
//
//@Component
//public class SolicitationListener {
//	
//	private static final Logger logger = LoggerFactory.getLogger(SolicitationListener.class);
//
//	@Autowired
//    ProcessSolicitationService processSolicitationService;
//    
//    
//    @SqsListener(Constants.QUEUE_TEAM_CARDS)
//    public void receiveStringMessageTeamCards(Solicitation solicitation) {
//        logger.info("Received message to Team Cards: {}", solicitation);
//        processSolicitationService.respondToSolicitation(solicitation);
//    }
//    
//    @SqsListener(Constants.QUEUE_TEAM_LOAN)
//    public void receiveStringMessageTeamLoan(Solicitation solicitation) {
//        logger.info("Received message to Team Loan: {}", solicitation);
//        processSolicitationService.respondToSolicitation(solicitation);
//    }
//    
//    @SqsListener(Constants.QUEUE_TEAM_OTHER_SUBJECTS)
//    public void receiveStringMessageTeamOtherSubjects(Solicitation solicitation) {
//        logger.info("Received message to Team Other Subjects: {}", solicitation);
//        processSolicitationService.respondToSolicitation(solicitation);
//    }
//
//}
