package br.com.traveller.util;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class AuthorizationListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String page = context.getViewRoot().getViewId();
        System.out.println(page);
        if(page.equals("/login.xhtml")) return;
        if(page.equals("/register.xhtml")) return;
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
