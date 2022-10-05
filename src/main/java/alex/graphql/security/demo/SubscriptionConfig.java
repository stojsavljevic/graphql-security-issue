package alex.graphql.security.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import alex.graphql.security.demo.gql.types.Post;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

@Configuration
public class SubscriptionConfig {

	@Bean
	Many<Post> publisher() {
		return Sinks.many().multicast().directBestEffort();
	}
}
