package br.com.testeubots.configuration;


import java.net.URI;
import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.awspring.cloud.sqs.config.SqsMessageListenerContainerFactory;
import io.awspring.cloud.sqs.listener.ListenerMode;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class SqsConfig {

	@Bean
	public SqsAsyncClient sqsAsyncClient() {
		return SqsAsyncClient.builder()
				.endpointOverride(URI.create("http://localhost:4566/"))
				.region(Region.SA_EAST_1)
				.build();
	}

	@Bean
	public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient) {
		return (SqsTemplate) SqsTemplate.newSyncTemplate(sqsAsyncClient);
	}

	@Bean
	SqsMessageListenerContainerFactory<Object> defaultSqsListenerContainerFactory(SqsAsyncClient sqsAsyncClient) {
		return SqsMessageListenerContainerFactory.builder()
				.configure(options -> options.listenerMode(ListenerMode.BATCH).maxMessagesPerPoll(3).pollTimeout(Duration.ofSeconds(20)))
				.sqsAsyncClient(sqsAsyncClient).build();
	}

}
