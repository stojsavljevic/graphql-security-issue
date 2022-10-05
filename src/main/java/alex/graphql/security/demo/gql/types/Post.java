package alex.graphql.security.demo.gql.types;

public class Post {

	private String id;

	private String title;

	private String authorId;

	public Post(String id, String title, String authorId) {
		this.id = id;
		this.title = title;
		this.authorId = authorId;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthorId() {
		return authorId;
	}

}
