package br.com.traveller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.connection.ConnectionType;
import br.com.traveller.dao.PhoneDao;
import br.com.traveller.dao.impl.PhoneDaoImpl;
import br.com.traveller.model.Phone;

public class App {
    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getInstance(ConnectionType.QUERY).createEntityManager();

        PhoneDao daoPhone = new PhoneDaoImpl(em);

        // Encontrar todos os telefones por parte do nome de cliente
        System.out.println("\n\nEncontrar todos os telefones por parte do nome de cliente");
        String header = String.format("| %-50s", "Nome") + String.format("| %-15s ", "Fone")
                + String.format("| %-9s |", "Tipo");
        System.out.println(header);

        List<Phone> phones = daoPhone.findByCustomerNameContainingIgnoreCase("eMIlly");

        for (Phone phone : phones) {

            String name = String.format("| %-50s", phone.getCustomer().getName());
            String number = String.format("| %-15s ",
                    phone.getNumber().replaceAll("^([0-9]{2})([0-9]{4,5})([0-9]{4})$", "($1) $2-$3"));
            String type = String.format("| %-9s |", phone.getType().toString());

            System.out.println(name + number + type);
        }

        // close
        em.close();
        ConnectionFactory.getInstance(ConnectionType.QUERY).close();
    }
}
