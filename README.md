# Steps to reproduce the issue
* open <http://localhost:8082/graphiql>
* authenticate with admin/admin
* execute test query to check it works

```
query {
  testQuery
}
```
* execute subscription

```
subscription {
  getNewPost{
    id
    title
    author {
      id
      name
    }
  }
}
```
* open another graphiql editor in new tab
* execute mutation

```
mutation {
  createPost(createPostInput: {
    title: "Lorem Ipsum"
    authorId: "123"
  }){
    id
    title
    author {
      name
    }
  }
}
```
* note that subscription received the response
* at this point authentication is lost and following request will be redirected to login page

# Notes
* In case that `Post` object doesn't contain nested `Author` object, everything works as it should
* With Java Kickstart (code is here but commented out) everything works as it should


# Links
* <https://github.com/graphql-java/graphql-java-spring/issues/8>