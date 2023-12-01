package de.mnbn.quickstartquerypathcomparison.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Embeddable
public class PostId extends AbstractEntityId {

    @Column(name = "id", updatable = false, nullable = false)
    private UUID idValue;

    public PostId() {
    }

    public PostId(UUID idValue) {
        this.idValue = idValue;
    }

    public static PostId of(UUID value) {
        return new PostId(requireNonNull(value));
    }

    public UUID getIdValue() {
        return idValue;
    }

}
