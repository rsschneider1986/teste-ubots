//package br.com.testeubots.queue;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import br.com.testeubots.model.Solicitation;
//import io.awspring.cloud.sqs.operations.SqsTemplate;
//
//public class SolicitationSenderTest {
//
//	@InjectMocks
//	private SolicitationSender sender;
//
//	@Mock
//	private SqsTemplate template;
//
//	@Test
//	void sendSolicitationToTeamCards() {
//		sender.sendSolicitationToTeamCards(new Solicitation("cards"));
//		verify(template).send(any(), any(Solicitation.class));
//	}
//
//	@Test
//	void sendSolicitationToTeamLoan() {
//		sender.sendSolicitationToTeamLoan(new Solicitation("loan"));
//		verify(template).send(any(), any(Solicitation.class));
//	}
//
//	@Test
//	void sendSolicitationToTeamOthersSubjects() {
//		sender.sendSolicitationToTeamOthersSubjects(new Solicitation("other subjects"));
//		verify(template).send(any(), any(Solicitation.class));
//	}
//
//}
