package alex.graphql.security.demo.gql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alex.graphql.security.demo.AppService;
import alex.graphql.security.demo.gql.types.CreatePostInput;
import alex.graphql.security.demo.gql.types.Post;

/**
 * Java Kickstart resolver.
 */
@Component
public class MutationResolver /* implements GraphQLMutationResolver */ {

	@Autowired
	AppService appService;
	
	public Post createPost(CreatePostInput createPostInput) {
		return this.appService.createPost(createPostInput);
	}
}
