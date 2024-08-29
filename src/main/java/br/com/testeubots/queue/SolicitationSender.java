package br.com.testeubots.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testeubots.model.Solicitation;
import br.com.testeubots.util.Constants;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SolicitationSender {

	@Autowired
	private SqsTemplate sqsTemplate;

	public void sendSolicitationToTeamCards(Solicitation solicitation) {
		try {
			sqsTemplate.send(Constants.ENDPOINT_QUEUE_TEAM_CARDS, solicitation);
			log.debug(" --> Send Solicitation To Team Cards '{}'", solicitation);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void sendSolicitationToTeamLoan(Solicitation solicitation) {
		try {
			sqsTemplate.send(Constants.ENDPOINT_QUEUE_TEAM_LOAN, solicitation);
			log.debug(" --> Send Solicitation To Team Loan'{}'", solicitation);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void sendSolicitationToTeamOthersSubjects(Solicitation solicitation) {
		try {
			sqsTemplate.send(Constants.ENDPOINT_QUEUE_TEAM_OTHER_SUBJECTS, solicitation);
			log.debug(" --> Send Solicitation To Team Others Subjects '{}'", solicitation);
		} catch (Exception e) {
			log.error(e);
		}
	}

}
