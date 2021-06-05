package br.com.traveller.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static final String PERSISTENCE_UNIT = "oraclePU";

    private static EntityManagerFactory factory;

    private ConnectionFactory() {
    }

    public static EntityManagerFactory getInstance() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        return factory;
    }
}
