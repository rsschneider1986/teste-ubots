package br.com.testeubots;

import static org.testcontainers.containers.localstack.LocalStackContainer.Service.SQS;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import br.com.testeubots.util.Constants;

@Testcontainers
class TesteUbotsApplicationTests {
	
    private static final String LOCAL_STACK_VERSION = "localstack/localstack:3.6.0";

	@Container
	static LocalStackContainer localStack = new LocalStackContainer(DockerImageName.parse(LOCAL_STACK_VERSION));

	@DynamicPropertySource
	static void overrideProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.cloud.aws.region.static", () -> localStack.getRegion());
		registry.add("spring.cloud.aws.credentials.access-key", () -> localStack.getAccessKey());
		registry.add("spring.cloud.aws.credentials.secret-key", () -> localStack.getSecretKey());
		registry.add("spring.cloud.aws.sqs.endpoint", () -> localStack.getEndpointOverride(SQS).toString());
		registry.add(Constants.QUEUE_TEAM_CARDS, () -> "test-" + Constants.QUEUE_TEAM_CARDS);
		registry.add(Constants.QUEUE_TEAM_LOAN, () -> "test-" + Constants.QUEUE_TEAM_LOAN);
		registry.add(Constants.QUEUE_TEAM_OTHER_SUBJECTS, () -> "test-" + Constants.QUEUE_TEAM_OTHER_SUBJECTS);
	}

}
