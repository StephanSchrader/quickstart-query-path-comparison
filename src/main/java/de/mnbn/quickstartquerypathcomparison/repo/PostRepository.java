package de.mnbn.quickstartquerypathcomparison.repo;

import de.mnbn.quickstartquerypathcomparison.model.CommentId;
import de.mnbn.quickstartquerypathcomparison.model.Post;
import de.mnbn.quickstartquerypathcomparison.model.PostId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, PostId> {

    @Query("select p from Post p where exists (select c from Comment c WHERE c.postId = p.id and c.id = :commentId)")
    List<Post> findAllByCommentId(CommentId commentId);

}
