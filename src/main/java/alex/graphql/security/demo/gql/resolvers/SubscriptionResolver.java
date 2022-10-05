package alex.graphql.security.demo.gql.resolvers;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alex.graphql.security.demo.gql.types.Post;
import reactor.core.publisher.Sinks.Many;

/**
 * Java Kickstart resolver.
 */
@Component
class SubscriptionResolver /* implements GraphQLSubscriptionResolver */{

	@Autowired
	Many<Post> publisher;

	Publisher<Post> getNewPost() {
		return publisher.asFlux();
	}
}