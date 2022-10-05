package alex.graphql.security.demo.gql.resolvers;

import org.springframework.stereotype.Component;

/**
 * Java Kickstart resolver.
 */
@Component
public class QueryResolver/* implements GraphQLQueryResolver */ {

	public String testQuery() {
		return "It works!";
	}
}
