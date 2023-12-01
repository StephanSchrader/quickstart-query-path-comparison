package de.mnbn.quickstartquerypathcomparison.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends AbstractEntity<CommentId> {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @AttributeOverride(name = "idValue", column = @Column(name = "post_id", insertable = false, updatable = false))
    private PostId postId;

    private String text;

    public Comment() {
    }

    public Comment(String text, Post post) {
        this.text = text;
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostId getPostId() {
        return postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
