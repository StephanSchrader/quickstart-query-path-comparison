package de.mnbn.quickstartquerypathcomparison.model;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.UUID;

public class EntityIdGenerator implements IdentifierGenerator {

    private Method method;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        Class<?> idType = type.getReturnedClass();
        if (!AbstractEntityId.class.isAssignableFrom(idType)) {
            throw new MappingException("Only implementations of EntityId class are supported!");
        }

        try {
            method = idType.getMethod("of", UUID.class);
        } catch (NoSuchMethodException e) {
            throw new MappingException("No suitable constructor found", e);
        }

    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        try {
            return (Serializable) method.invoke(object, UUID.randomUUID());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new HibernateException("Failed to create new id instance", e);
        }
    }

}
