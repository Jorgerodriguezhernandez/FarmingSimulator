package com.company;

public class Huerto {
    private String buff[];
    private int top = 0;
    private boolean full= false;
    private boolean empty = true;


    public Huerto(int capacidad) {
        this.buff = new String[capacidad];
    }


    public synchronized void Cultivar( String verdura) throws InterruptedException{
        while (full){
            wait();
        }
        buff[top]= verdura;
        top = top + 1;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }



}
