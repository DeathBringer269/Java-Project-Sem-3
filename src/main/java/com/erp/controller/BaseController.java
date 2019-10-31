package main.java.com.erp.controller;


import main.java.com.erp.view.ViewFactory;

public class BaseController {

    protected ViewFactory viewFactory;

    protected String fxmlName;

    BaseController(ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
