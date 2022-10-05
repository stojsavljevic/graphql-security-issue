package alex.graphql.security.demo.gql.types;

public class Author {

	private String id;

	private String name;

	public Author(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
