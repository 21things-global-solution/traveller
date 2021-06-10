package br.com.traveller;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.dao.AddressDao;
import br.com.traveller.dao.impl.AddressDaoImpl;
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

public class StoreData {
    public static void main(String[] args) {
        // Data obtained in:
        // https://www.4devs.com.br/gerador_de_cpf
        // https://www.4devs.com.br/gerador_de_pessoas
        // https://all.accor.com/ssr/app/mercure/rates/6284/index.pt-br.shtml?compositions=1&stayplus=false&dateIn=2021-06-06&nights=1&destination=Sao%20paulo,%20Brasil
        // https://www.hurb.com/br/hotels/sao-paulo/sheraton-sao-paulo-wtc-hotel-OMN-5211?cmp=396312&prm=515&gclid=Cj0KCQjwweyFBhDvARIsAA67M71sZqQhzCz06Fqyv_Woa7T3-tv3mT2n4bhw811ulkkQRJl2NuxmrYgaAtGGEALw_wcB
        // https://www.bourbon.com.br/hotel/bourbon-convention-ibirapuera-hotel/
        // https://www.bluetree.com.br/hotel/blue-tree-premium-paulista/
        // https://www.marriott.com/hotels/travel/saobr-renaissance-sao-paulo-hotel/
        // https://www.marriott.com/hotels/travel/saobr-renaissance-sao-paulo-hotel/

        EntityManager em = ConnectionFactory.getInstance().createEntityManager();

        Hotel hotel1 = new Hotel("IBIS Styles São Paulo Anhembi", "1133365400", "https://all.accor.com/hotel/9596/index.pt-br.shtml", "h9596-re@accor.com.br");
        Hotel hotel2 = new Hotel("Comfort Ibirapuera", "1146730255");
        Hotel hotel3 = new Hotel("Blue Tree Premium Morumbi", "1151871200");
        Hotel hotel4 = new Hotel("Mercure São Paulo Pamplona", "1128785500");
        Hotel hotel5 = new Hotel("Sheraton São Paulo WTC Hotel", "1130558000");
        Hotel hotel6 = new Hotel("Bourbon Convention Ibirapuera", "1121612200");
        Hotel hotel7 = new Hotel("Blue Tree Premium Paulista", "1131477000");
        Hotel hotel8 = new Hotel("Golden Tulip Paulista Plaza", "1126271000");
        Hotel hotel9 = new Hotel("Renaissance São Paulo Hotel", "1130692233");

        ZipCode zipCode1 = new ZipCode("Avenida Cruzeiro do Sul", "Santana", "São Paulo", "02031000", State.SP);
        ZipCode zipCode2 = new ZipCode("Avenida Sabiá", "Indianópolis", "São Paulo", "04515001", State.SP);
        ZipCode zipCode3 = new ZipCode("Avenida Roque Petroni Júnior", "Vila Gertrudes", "São Paulo", "04707000", State.SP);
        ZipCode zipCode4 = new ZipCode("Rua Pamplona", "Jardim Paulista", "São Paulo", "01405002", State.SP);
        ZipCode zipCode5 = new ZipCode("Avenida das Nações Unidas", "Brooklin Novo", "São Paulo", "04578903", State.SP);
        ZipCode zipCode6 = new ZipCode("Avenida Ibirapuera", "Ibirapuera", "São Paulo", "04029200", State.SP);
        ZipCode zipCode7 = new ZipCode("Rua Peixoto Gomide", "Bela Vista", "São Paulo", "01409001", State.SP);
        ZipCode zipCode8 = new ZipCode("Alameda Santos", "Jardins", "São Paulo", "01419000", State.SP);
        ZipCode zipCode9 = new ZipCode("Alameda Santos", "Jardim Paulista", "São Paulo", "01419002", State.SP);

        Address address1 = new Address("1709", zipCode1);
        Address address2 = new Address("825", zipCode2);
        Address address3 = new Address("100", zipCode3);
        Address address4 = new Address("1315", zipCode4);
        Address address5 = new Address("12559", zipCode5);
        Address address6 = new Address("2927", zipCode6);
        Address address7 = new Address("707", zipCode7);
        Address address8 = new Address("85", zipCode8);
        Address address9 = new Address("2233", zipCode9);

        Room room1 = new Room("Quarto Standard com 1 cama de solteiro", RoomType.SOLTEIRO, 170d, hotel1);
        Room room2 = new Room("Quarto Standard com 1 cama de casal", RoomType.CASAL, 314d, hotel1);
        Room room3 = new Room("LUXO TWIN NÃO FUMANTE", RoomType.DUPLO_SOLTEIRO, 172d, hotel2);
        Room room4 = new Room("SUPERIOR QUEEN NÃO FUMANTE", RoomType.CASAL, 192d, hotel2);
        Room room5 = new Room("Superior 2 camas de solteiro", RoomType.DUPLO_SOLTEIRO, 173.55, hotel3);
        Room room6 = new Room("Luxo 2 camas de solteiro", RoomType.DUPLO_SOLTEIRO, 230d, hotel3);
        Room room7 = new Room("Quarto superior com 2 camas de solteiro", RoomType.DUPLO_SOLTEIRO, 235d, hotel4);
        Room room8 = new Room("Quarto Privilege com 1 cama king size, Andar Exec", RoomType.CASAL, 246.60, hotel4);
        Room room9 = new Room("Classic Queen", RoomType.SOLTEIRO, 344d, hotel5);
        Room room10 = new Room("Executive King", RoomType.CASAL, 356d, hotel5);
        Room room11 = new Room("SUPERIOR TWIN", RoomType.DUPLO_SOLTEIRO, 236d, hotel6);
        Room room12 = new Room("SUITE PREMIUM", RoomType.CASAL, 364.90, hotel6);
        Room room13 = new Room("Superior - 2 Camas de Solteiro", RoomType.DUPLO_SOLTEIRO, 291d, hotel7);
        Room room14 = new Room("Suíte Premium - Cama de Casal", RoomType.CASAL, 333d, hotel7);
        Room room15 = new Room("2 Twin Beds", RoomType.DUPLO_SOLTEIRO, 207d, hotel8);
        Room room16 = new Room("Premium Room-2 Twin Beds", RoomType.DUPLO_SOLTEIRO, 350d, hotel8);
        Room room17 = new Room("Deluxe, Guest room, 1 King", RoomType.CASAL, 672d, hotel9);
        Room room18 = new Room("Deluxe, Guest room, 2 Double", RoomType.DUPLO_SOLTEIRO, 699.12, hotel9);

        Customer customer1 = new Customer("Luís Paulino", "rm85398@fiap.com.br", "123456");
        Customer customer2 = new Customer("Natália Emilly Nogueira", "nnataliaemillynogueira@accent.com.br","agyf0ime");
        Customer customer3 = new Customer("Marcelo Osvaldo Guilherme Ribeiro", "marceloosvaldoguilhermeribeiro..marceloosvaldoguilhermeribeiro@reval.net","5n51bsxg");
        Customer customer4 = new Customer("Melissa Luiza Emilly Mendes", "mmelissaluizaemillymendes@techdomus.com.br","f5yruush");
        Customer customer5 = new Customer("Diego Renan Giovanni Santos", "diegorenangiovannisantos..diegorenangiovannisantos@pozzer.net","josfjeqk");

        Phone phone1 = new Phone("21993944049", PhoneType.CELULAR);
        Phone phone2 = new Phone("2138870619", PhoneType.FIXO);
        Phone phone3 = new Phone("9237186927", PhoneType.COMERCIAL);
        Phone phone4 = new Phone("92986574626", PhoneType.CELULAR);
        Phone phone5 = new Phone("47985564300", PhoneType.CELULAR);
        Phone phone6 = new Phone("91989292991", PhoneType.CELULAR);
        Phone phone7 = new Phone("89984453379", PhoneType.CELULAR);

        Reservation reservation1 = new Reservation(LocalDate.of(2021, Calendar.JUNE, 6), LocalDate.of(2021, Calendar.JUNE, 13));
        Reservation reservation2 = new Reservation(LocalDate.of(2021, Calendar.JULY, 6), LocalDate.of(2021, Calendar.JULY, 13));
        Reservation reservation3 = new Reservation(LocalDate.of(2020, Calendar.AUGUST, 6), LocalDate.of(2020, Calendar.AUGUST, 13));
        Reservation reservation4 = new Reservation(LocalDate.of(2021, Calendar.SEPTEMBER, 6), LocalDate.of(2021, Calendar.SEPTEMBER, 13));
        Reservation reservation5 = new Reservation(LocalDate.of(2020, Calendar.OCTOBER, 6), LocalDate.of(2020, Calendar.OCTOBER, 13));

        // Link data
        customer1.addPhone(phone1);
        customer1.addPhone(phone2);
        customer2.addPhone(phone3);
        customer2.addPhone(phone4);
        customer3.addPhone(phone5);
        customer4.addPhone(phone6);
        customer5.addPhone(phone7);

        hotel1.addRooms(room1);
        hotel1.addRooms(room2);
        hotel2.addRooms(room3);
        hotel2.addRooms(room4);
        hotel3.addRooms(room5);
        hotel3.addRooms(room6);
        hotel4.addRooms(room7);
        hotel4.addRooms(room8);
        hotel5.addRooms(room9);
        hotel5.addRooms(room10);
        hotel6.addRooms(room11);
        hotel6.addRooms(room12);
        hotel7.addRooms(room13);
        hotel7.addRooms(room14);
        hotel8.addRooms(room15);
        hotel8.addRooms(room16);
        hotel9.addRooms(room17);
        hotel9.addRooms(room18);

        hotel3.setSite("https://www.bluetree.com.br/hotel/blue-tree-premium-morumbi/");
        hotel4.setSite("https://mercure.accor.com");
        hotel5.setSite("http://www.sheratonsaopaulowtc.com.br");
        hotel6.setSite("https://www.bourbon.com.br/hotel/bourbon-convention-ibirapuera-hotel/");
        hotel7.setSite("https://www.bluetree.com.br/hotel/blue-tree-premium-paulista/");
        hotel8.setSite("https://www.radissonhotelsamericas.com/en-us/hotels/radisson-sao-paulo-paulista");
        hotel9.setSite("https://www.marriott.com/hotels/travel/saobr-renaissance-sao-paulo-hotel/");

        hotel6.setMail("reservas.conv@bourbon.com.br");
        hotel8.setMail("vendas.rdpa@atlanticahotels.com.br");

        hotel1.setImage("ibis-styles-anhembi.jpg");
        hotel2.setImage("comfort-ibirapurera.jpg");
        hotel3.setImage("blue-tree-morumbi.jpg");
        hotel4.setImage("mercure-pamplona.jpg");
        hotel5.setImage("sheraton-wtc.jpg");
        hotel6.setImage("bourbon-ibirapuera.jpg");
        hotel7.setImage("blue-tree-paulista.jpg");
        hotel8.setImage("golden-tulip-paulista.jpg");
        hotel9.setImage("renaissance-sao-paulo.jpg");

        hotel1.setRating(2);
        hotel2.setRating(3);
        hotel3.setRating(4);
        hotel4.setRating(4);
        hotel5.setRating(5);
        hotel6.setRating(3);
        hotel7.setRating(4);
        hotel8.setRating(4);
        hotel9.setRating(5);

        address1.setHotel(hotel1);
        address2.setHotel(hotel2);
        address3.setHotel(hotel3);
        address4.setHotel(hotel4);
        address5.setHotel(hotel5);
        address6.setHotel(hotel6);
        address7.setHotel(hotel7);
        address8.setHotel(hotel8);
        address9.setHotel(hotel9);

        room1.addReservation(reservation1);
        room2.addReservation(reservation3);
        room3.addReservation(reservation2);
        room6.addReservation(reservation4);
        room14.addReservation(reservation5);

        customer1.addReservation(reservation1);
        customer2.addReservation(reservation5);
        customer4.addReservation(reservation3);
        customer3.addReservation(reservation4);
        customer5.addReservation(reservation2);

        // Dao instance
        AddressDao dao = new AddressDaoImpl(em);

        // Populate database
        dao.create(address1);
        dao.create(address2);
        dao.create(address3);
        dao.create(address4);
        dao.create(address5);
        dao.create(address6);
        dao.create(address7);
        dao.create(address8);
        dao.create(address9);
        try {
            dao.commit();
            System.out.println("\n\nDados cadastrados com sucesso!");
        } catch (TransactionException e) {
            System.err.println("\n\nExceção: " + e.getMessage());
        } finally {
            // Close
            em.close();
            ConnectionFactory.getInstance().close();
        }
    }
}
