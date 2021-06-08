package br.com.traveller;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.dao.HotelDao;
import br.com.traveller.dao.PhoneDao;
import br.com.traveller.dao.RoomDao;
import br.com.traveller.dao.impl.HotelDaoImpl;
import br.com.traveller.dao.impl.PhoneDaoImpl;
import br.com.traveller.dao.impl.RoomDaoImpl;
import br.com.traveller.model.Phone;
import br.com.traveller.model.Room;
import br.com.traveller.model.RoomType;

/**
 * To work properly, before run this file, change `hibernate.hbm2ddl.auto` in
 * `persistence.xml` of `update` to `validate`
 */
public class App {
    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getInstance().createEntityManager();

        PhoneDao daoPhone = new PhoneDaoImpl(em);

        System.out.println("\n\nEncontrar todos os telefones por parte do nome de cliente\n");
        String header = String.format("| %-50s", "Nome") + String.format("| %-15s ", "Fone")
                + String.format("| %-9s |", "Tipo");

        List<Phone> phones = daoPhone.findByCustomerNameContainingIgnoreCase("eMIlly");

        System.out.println(header);
        for (Phone phone : phones) {

            String name = String.format("| %-50s", phone.getCustomer().getName());
            String number = String.format("| %-15s ",
                    phone.getNumber().replaceAll("^([0-9]{2})([0-9]{4,5})([0-9]{4})$", "($1) $2-$3"));
            String type = String.format("| %-9s |", phone.getType().toString());

            System.out.println(name + number + type);
        }

        RoomDao daoRoom = new RoomDaoImpl(em);

        System.out.println("\n\nEncontrar todos os quartos que o valor seja inferior\n");
        header = String.format("| %-30s ", "Hotel") + String.format("| %-50s ", "Quarto")
                + String.format("| %-6s |", "Valor");

        List<Room> rooms = daoRoom.findByValueLessThan(237d);

        System.out.println(header);
        for (Room room : rooms) {

            String hotelName = String.format("| %-30s ", room.getHotel().getName());
            String roomDescription = String.format("| %-50s ", room.getDescription());
            String roomValue = String.format("| %.2f |", room.getValue());

            System.out.println(hotelName + roomDescription + roomValue);
        }

        HotelDao daoHotel = new HotelDaoImpl(em);

        System.out.println("\n\nExibe o total por tipo de quarto\n");
        header = String.format("| %-15s ", "Tipo Quarto") + String.format("| %-5s |", "Total");

        Long count = daoHotel.countAllByHotelNameAndRoomType("Comfort Ibirapuera", RoomType.DUPLO_SOLTEIRO);

        System.out.println(header);
        System.out.println(String.format("| %-15s ", RoomType.DUPLO_SOLTEIRO) + String.format("| %5d |", count));
        // close
        em.close();
        ConnectionFactory.getInstance().close();
    }
}
