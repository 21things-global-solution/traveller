package br.com.traveller.bean;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.dao.ReservationDao;
import br.com.traveller.dao.impl.ReservationDaoImpl;
import br.com.traveller.exception.TransactionException;
import br.com.traveller.model.Customer;
import br.com.traveller.model.Reservation;
import br.com.traveller.model.Room;

@Named(value = "book")
@RequestScoped
public class ReservationBean {

    private static final FacesContext context = FacesContext.getCurrentInstance();

    private static final Customer customer = (Customer) context.getExternalContext().getSessionMap().get("customer");

    private Reservation reservation = new Reservation();

    private Room room = new Room();

    private EntityManager manager = ConnectionFactory.getInstance().createEntityManager();

    private final ReservationDao dao = new ReservationDaoImpl(manager);

    private final LocalDate checkInMinDate = LocalDate.now();

    private final LocalDate checkOutMinDate = LocalDate.now().plusDays(1);

    public void save() {
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        
        dao.create(reservation);
        try {
            dao.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        context.addMessage(null, new FacesMessage("Reserva efetuada com sucesso!"));
    }

    public List<Reservation> getReservations(){
        return dao.findAllByCustomer(customer);
    }

    public LocalDate getCheckInMinDate() {
        return checkInMinDate;
    }

    public LocalDate getCheckOutMinDate() {
        return checkOutMinDate;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
