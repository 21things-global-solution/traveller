package br.com.traveller.connection;

import static br.com.traveller.connection.ConnectionType.QUERY;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static final String PERSISTENCE_UNIT_DML = "dml-persistence-unit";
    private static final String PERSISTENCE_UNIT_DQL = "dql-persistence-unit";

    private static EntityManagerFactory factory;

    private ConnectionFactory() {
    }

    public static EntityManagerFactory getInstance(ConnectionType type) {
        if (factory == null) {
            boolean isQuery = type.equals(QUERY);
            factory = Persistence.createEntityManagerFactory(isQuery ? PERSISTENCE_UNIT_DQL : PERSISTENCE_UNIT_DML);
        }

        return factory;
    }
}
