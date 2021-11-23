package com.company;

public class Cliente extends Thread{

    private Huerto buffer;
    private int expectedUnits;
    private int maxWaitTime;

    public Cliente(Huerto buffer, int expectedUnits, int maxWaitTime) {
        this.buffer = buffer;
        this.expectedUnits = expectedUnits;
        this.maxWaitTime = maxWaitTime;
    }
    @Override
    public synchronized void run() {
        String verdGen;
        try {
            for (int i = 0; i < expectedUnits; i++) {
                verdGen = buffer.comprar();
                System.out.println("El cliente compro: " + verdGen);
                sleep((int) (Math.random() * this.maxWaitTime));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
