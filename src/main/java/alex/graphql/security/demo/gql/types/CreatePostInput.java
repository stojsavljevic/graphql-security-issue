package alex.graphql.security.demo.gql.types;

public class CreatePostInput {

	private String title;

	private String authorId;

	public CreatePostInput(String title, String authorId) {
		super();
		this.title = title;
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthorId() {
		return authorId;
	}

}
