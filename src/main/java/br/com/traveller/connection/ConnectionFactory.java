package br.com.traveller.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static final String ORACLE_PERSISTENCE_UNIT = "oracle-persistence-unit";

    private static EntityManagerFactory factory;

    private ConnectionFactory() {
    }

    public static EntityManagerFactory getInstance() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(ORACLE_PERSISTENCE_UNIT);
        }

        return factory;
    }
}
