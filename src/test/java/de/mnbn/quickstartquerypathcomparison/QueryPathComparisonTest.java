package de.mnbn.quickstartquerypathcomparison;

import de.mnbn.quickstartquerypathcomparison.model.Post;
import de.mnbn.quickstartquerypathcomparison.repo.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QueryPathComparisonTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void save_and_load_with_postId() {
        var post = new Post();
        post.setName("Lorem Ipsum");
        post.addComment("Hello World");
        post = postRepository.save(post);

        var posts = postRepository.findAllByCommentId(post.getComments().get(0).getId());
        assertThat(posts).hasSize(1);
    }
}
