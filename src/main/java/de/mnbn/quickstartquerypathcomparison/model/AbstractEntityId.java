package de.mnbn.quickstartquerypathcomparison.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractEntityId implements Serializable {

    public abstract UUID getIdValue();

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), getIdValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostId postId = (PostId) o;

        return Objects.equals(getIdValue(), postId.getIdValue());
    }

    @Override
    public int hashCode() {
        return getIdValue() != null ? getIdValue().hashCode() : 0;
    }

}
