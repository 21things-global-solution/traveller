package br.com.traveller.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.traveller.model.Customer;

public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String page = context.getViewRoot().getViewId();
        if (page.matches("^/(login|register).xhtml$")) {
            return;
        }

        Customer customer = (Customer) context.getExternalContext().getSessionMap().get("customer");
        if (customer == null) {
            NavigationHandler navigation = context.getApplication().getNavigationHandler();
            navigation.handleNavigation(context, "", "login?faces-redirect=true");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
