package br.com.traveller.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.traveller.connection.ConnectionFactory;
import br.com.traveller.dao.CustomerDao;
import br.com.traveller.dao.impl.CustomerDaoImpl;
import br.com.traveller.model.Customer;

@Named
@RequestScoped
public class CustomerBean {

    private Customer customer = new Customer();

    private static final EntityManager manager = ConnectionFactory.getInstance().createEntityManager();

    private static final CustomerDao dao = new CustomerDaoImpl(manager);

    private final FacesContext context = FacesContext.getCurrentInstance();

    public String login() {
        ExternalContext externalContext = context.getExternalContext();
        customer = dao.findByMailAndPassword(customer);
        if (customer == null) {
            externalContext.getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado", null));
            return "login?faces-redirect=true";
        }
        externalContext.getSessionMap().put("customer", customer);
        return "index?faces-redirect=true";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
