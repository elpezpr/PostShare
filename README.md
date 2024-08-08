*** Project Description ***

The PostShare application is a social media platform where users can create and share posts, as well as comment on them. Built with Java Spring Boot, it utilizes JPA for managing backend operations and provides RESTful APIs for performing CRUD operations on posts and comments.

*** Features ***

Posts: Users can create, update, and delete posts. Each post contains a title, content, author information, and optional metadata such as creation date and summary.

Comments: Users can comment on posts. Each comment is associated with a specific post and includes the content of the comment, the author's information, and the creation date.

*** Class Diagram ***

    -------------------------------------            -----------------------------
    |                Post               |            |          Comment          |
    -------------------------------------            -----------------------------
    | id: Long                          |            | id: Long                  |
    | title: String                     |------------| content: String           |
    | content: String                   |1          *| post: Post                |
    | metadata: PostMetadata            |            | createdDate: LocalDateTime|
    | author: String                    |            | author: String            |
    | comments: Comment                 |            |                           |
    -------------------------------------            -----------------------------
                  |
                  | 1
                  |
    -------------------------------
    |       PostMetadata           |
    -------------------------------
    | createdDate: LocalDateTime   |
    | summary: String              |
    -------------------------------

*** Technologies Used ***

Java
Spring Boot
Spring Data JPA
MySQL
Lombok
Jakarta Validation

*** Development Tools ***

IntelliJ IDEA
GitHub
DBeaver
Postman

*** Usage ***

To use the PostShare application, you need to run both the backend and frontend services.

Backend: Clone and start the backend server by running the Spring Boot application. Once running, the backend will be accessible via RESTful API endpoints.

Frontend: Clone and run the frontend application from the following repository: [PostShare-FrontEnd](https://github.com/elpezpr/PostShare-FrontEnd). Follow the instructions in the frontend repository's README to set up and start the user interface.

Interaction: Once both the backend and frontend are running, you can interact with the application through the frontend UI. This interface will allow you to create, view, update, and delete posts and comments directly, utilizing the backend APIs.

*** Endpoints ***

Posts
- GET /api/posts: Get all posts
- GET /api/posts/{id}: Get a post by ID
- GET /api/posts/author/{author}: Get posts by author
- POST /api/posts: Create a new post
- PUT /api/posts/{id}: Update an existing post by ID
- PATCH /api/posts/content/{id}: Update a post's content by ID
- DELETE /api/posts/{id}: Delete a post by ID

Comments
- GET /api/comments/{id}: Get a comment by ID
- GET /api/posts/{postId}/comments: Get all comments for a specific post
- POST /api/comments: Create a new comment
- DELETE /api/comments/{id}: Delete a comment by ID

Planned enhancements include adding advanced search capabilities, such as allowing users to search for posts based on specific keywords within their associated comments. This will further improve the application's search functionality.

*** Resources ***

https://www.sitepoint.com/rest-api/
https://betterprogramming.pub/building-a-spring-boot-rest-api-a-php-developers-view-part-i-6add2e794646
https://dzone.com/articles/the-simple-guide-to-http-verbs-patch-put-and-post
https://www.w3schools.com/
