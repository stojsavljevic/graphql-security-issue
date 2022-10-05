package alex.graphql.security.demo;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import alex.graphql.security.demo.gql.types.Author;
import alex.graphql.security.demo.gql.types.CreatePostInput;
import alex.graphql.security.demo.gql.types.Post;
import reactor.core.publisher.Sinks.Many;

@Controller
class AppController {

	@Autowired
	AppService appService;

	@Autowired
	Many<Post> publisher;

	@QueryMapping
	public String testQuery() {
		return "It works!";
	}

	@MutationMapping
	public Post createPost(@Argument CreatePostInput createPostInput) {
		return this.appService.createPost(createPostInput);
	}

	@SchemaMapping(typeName = "Post", field = "author")
	public Author getAuthor(Post post) {
		return this.appService.getAuthorById(post.getAuthorId());
	}

	@SubscriptionMapping("getNewPost")
	public Publisher<Post> getNewPost() {
		return this.publisher.asFlux();
	}

}
