package br.com.traveller.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

    public void execute() {
        System.out.println("\n\n\nIf you see this message in server log, then successfully worked");
    }
}
