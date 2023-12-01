package de.mnbn.quickstartquerypathcomparison.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class AbstractEntity<T extends AbstractEntityId> {

    @EmbeddedId
    @GeneratedValue(generator = "EntityId")
    @GenericGenerator(
            name = "EntityId",
            type = EntityIdGenerator.class
    )
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
