package alex.graphql.security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.graphql.security.demo.gql.types.Author;
import alex.graphql.security.demo.gql.types.CreatePostInput;
import alex.graphql.security.demo.gql.types.Post;
import reactor.core.publisher.Sinks.Many;

@Service
public class AppService {
	
	@Autowired
	Many<Post> publisher;

	public Author getAuthorById(String id) {
		Author author = new Author(id, "Stephen King");
		return author;
	}
	
	public Post createPost(CreatePostInput postInput) {
		
		Post post = new Post("1", postInput.getTitle(), postInput.getAuthorId());
		// not actually saving anything
		
		// publish newly created Post
		this.publisher.tryEmitNext(post);
		
		return post;
	}
	
}
