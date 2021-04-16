package com.trtjk.cons.states.v3.interfaces;

public class RefundEvent implements Event {
    @Override
    public String execute() {
        return "refund";
    }
}