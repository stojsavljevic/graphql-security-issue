package alex.graphql.security.demo.gql.resolvers;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import alex.graphql.security.demo.AppService;
import alex.graphql.security.demo.gql.types.Author;
import alex.graphql.security.demo.gql.types.Post;
import graphql.schema.DataFetchingEnvironment;

/**
 * Java Kickstart resolver.
 */
@Component
public class AuthorResolver /* implements GraphQLResolver<Post> */{
	
	@Autowired
	private AppService appService;
	
	public CompletableFuture<Author> author(Post post, DataFetchingEnvironment dfe) {
		
		return CompletableFuture.supplyAsync(() -> this.appService.getAuthorById(post.getAuthorId()));
	}
}
