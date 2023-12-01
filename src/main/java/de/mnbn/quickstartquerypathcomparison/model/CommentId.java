package de.mnbn.quickstartquerypathcomparison.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Embeddable
public class CommentId extends AbstractEntityId {

    @Column(name = "id", updatable = false, nullable = false)
    private UUID idValue;

    public CommentId() {
    }

    public CommentId(UUID idValue) {
        this.idValue = idValue;
    }

    public static CommentId of(UUID value) {
        return new CommentId(requireNonNull(value));
    }

    public UUID getIdValue() {
        return idValue;
    }
}
