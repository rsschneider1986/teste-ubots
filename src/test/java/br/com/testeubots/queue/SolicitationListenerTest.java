//package br.com.testeubots.queue;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.atLeastOnce;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import br.com.testeubots.model.Solicitation;
//import br.com.testeubots.service.ProcessSolicitationService;
//
//@ExtendWith(MockitoExtension.class)
//public class SolicitationListenerTest {
//
//	@Mock
//	private ProcessSolicitationService processSolicitationService;
//
//	@InjectMocks
//	private SolicitationListener listener;
//
//	@Test
//	void receiveStringMessageTeamCards() {
//		doNothing().when(processSolicitationService).respondToSolicitation(any());
//		final Solicitation solicitation = new Solicitation("cards");
//		listener.receiveStringMessageTeamCards(solicitation);
//		verify(processSolicitationService, atLeastOnce()).respondToSolicitation(any());
//	}
//	
//	@Test
//	void receiveStringMessageTeamLoan() {
//		doNothing().when(processSolicitationService).respondToSolicitation(any());
//		final Solicitation solicitation = new Solicitation("loan");
//		listener.receiveStringMessageTeamLoan(solicitation);
//		verify(processSolicitationService, atLeastOnce()).respondToSolicitation(any());
//	}
//	
//	@Test
//	void receiveStringMessageTeamOtherSubjects() {
//		doNothing().when(processSolicitationService).respondToSolicitation(any());
//		final Solicitation solicitation = new Solicitation("other subjects");
//		listener.receiveStringMessageTeamOtherSubjects(solicitation);
//		verify(processSolicitationService, atLeastOnce()).respondToSolicitation(any());
//	}
//
//}
