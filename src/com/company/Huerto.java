package com.company;

public class Huerto {
    private String buff[];
    private int top = 0;
    private boolean full= false;
    private boolean empty = true;


    public Huerto(int capacidad) {
        this.buff = new String[capacidad];
    }


    public synchronized void cultivar( String verdura) throws InterruptedException{
        while (full){
            wait();
        }
        buff[top]= verdura;
        top = top + 1;
        empty = false;
        full = top >= buff.length;
        notifyAll();
    }
    public synchronized String comprar() throws InterruptedException{
        while (empty){
            wait();
        }
        String verdura = buff[top-1];
        top = top - 1;
        full = false;
        empty = top <= 0;
        notifyAll();
        return verdura;
    }



}
