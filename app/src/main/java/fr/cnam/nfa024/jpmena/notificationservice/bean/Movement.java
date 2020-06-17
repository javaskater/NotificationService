package fr.cnam.nfa024.jpmena.notificationservice.bean;

import java.io.Serializable;

public class Movement implements Serializable {
    private int idFrom;
    private int idTo;
    private String movement;

    public int getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(int idFrom) {
        this.idFrom = idFrom;
    }

    public int getIdTo() {
        return idTo;
    }

    public void setIdTo(int idTo) {
        this.idTo = idTo;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }
}
