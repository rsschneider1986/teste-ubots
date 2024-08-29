package br.com.testeubots;

import static org.awaitility.Awaitility.await;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.testeubots.model.Solicitation;
import br.com.testeubots.service.ProcessSolicitationService;
import br.com.testeubots.util.Constants;
import io.awspring.cloud.sqs.operations.SqsTemplate;

@SpringBootTest
public class ExecuteTests extends TesteUbotsApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(ExecuteTests.class);

	@Autowired
	private SqsTemplate sqsTemplate;

    @Autowired
    private ProcessSolicitationService processSolicitationService;

	@Test
	void givenAStringPayloadToTeamCards_whenSend_shouldReceive() {
		Solicitation solicitation = new Solicitation("cards");
		sqsTemplate.send(to -> to.queue(Constants.QUEUE_TEAM_CARDS).payload(solicitation));
		logger.info("Message sent with payload {}", solicitation);
		await().atMost(Duration.ofSeconds(3)).until(() -> processSolicitationService.respondToSolicitation(solicitation));
	}
	
//	@Test
//	void givenAStringPayloadToTeamLoan_whenSend_shouldReceive() {
//		
//		Solicitation solicitation = new Solicitation("loan");
//		sqsTemplate.send(to -> to.queue(Constants.QUEUE_TEAM_LOAN).payload(solicitation));
//		logger.info("Message sent with payload {}", solicitation);
//		await().atMost(Duration.ofSeconds(3)).until(() -> processSolicitationService.respondToSolicitation(solicitation));
//	}
//	
//	@Test
//	void givenAStringPayloadToTeamOtherSubjects_whenSend_shouldReceive() {		
//		Solicitation solicitation = new Solicitation("other subjects");
//		sqsTemplate.send(to -> to.queue(Constants.QUEUE_TEAM_OTHER_SUBJECTS).payload(solicitation));
//		logger.info("Message sent with payload {}", solicitation);
//		await().atMost(Duration.ofSeconds(3)).until(() -> processSolicitationService.respondToSolicitation(solicitation));
//	}

}
