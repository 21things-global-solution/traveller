package br.com.traveller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.dao.HotelDao;
import br.com.traveller.dao.impl.HotelDaoImpl;
import br.com.traveller.exception.TransactionException;
import br.com.traveller.model.Address;
import br.com.traveller.model.Customer;
import br.com.traveller.model.Hotel;
import br.com.traveller.model.Phone;
import br.com.traveller.model.PhoneType;
import br.com.traveller.model.Reservation;
import br.com.traveller.model.Room;
import br.com.traveller.model.RoomType;
import br.com.traveller.model.State;
import br.com.traveller.model.ZipCode;

public class StoreDate {
    public static void main(String[] args) {
        // Data obtained in:
        // https://www.4devs.com.br/gerador_de_cpf
        // https://www.4devs.com.br/gerador_de_pessoas

        EntityManager em = ConnectionFactory.getInstance().createEntityManager();

        Hotel hotel1 = new Hotel("IBIS Styles São Paulo Anhembi", "1133365400", "https://all.accor.com/hotel/9596/index.pt-br.shtml", "h9596-re@accor.com.br");

        ZipCode zipCode1 = new ZipCode("Avenida Cruzeiro do Sul", "Santana", "São Paulo", "02031000", State.SP);

        Address address1 = new Address("1709", zipCode1);

        Room room1 = new Room("Quarto Standard com 1 cama de casal", RoomType.QUARTO_SOLTEIRO, 314d, hotel1);

        Customer customer1 = new Customer("Luís Paulino", "986.777.660-73", "rm85398@fiap.com.br");

        Phone phone1 = new Phone("21993944049", PhoneType.CELULAR);
        Phone phone2 = new Phone("2138870619", PhoneType.FIXO);

        Reservation reservation1 = new Reservation(new GregorianCalendar(2021, Calendar.JUNE, 6), new GregorianCalendar(2021, Calendar.JUNE, 13));

        // Link data
        customer1.addPhone(phone1);
        customer1.addPhone(phone2);

        hotel1.addRooms(room1);
        address1.setHotel(hotel1);

        reservation1.setHotel(hotel1);
        reservation1.setCustomer(customer1);

        // Dao instance
        HotelDao dao = new HotelDaoImpl(em);

        // Populate database
        dao.create(hotel1);
        try {
            dao.commit();
            System.out.println("\n\nDados cadastrados com sucesso!");
        } catch (TransactionException e) {
            System.err.println("\n\nExceção: " + e.getMessage());
        } finally{
            // Close
            em.close();
            ConnectionFactory.getInstance().close();
        }
    }
}
