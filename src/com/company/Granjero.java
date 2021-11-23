package com.company;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Granjero extends Thread{
    private Huerto buffer;
    private int unidadesProducidas;
    private int maxTiempoEspera;
    private static String[] verduras = {"lettuce",
            "cabbage",
            "onion",
            "spinach",
            "potato",
            "celery",
            "asparagus",
            "radish",
            "broccoli",
            "artichoke",
            "tomato",
    };
    public Granjero(Huerto buffer, int unidadesProducidas, int maxTiempoEspera){
        this.buffer=buffer;
        this.unidadesProducidas = unidadesProducidas;
        this.maxTiempoEspera = maxTiempoEspera;
    }


    @Override
    public synchronized void run() {
        String verdGen;
        try {
            for (int i = 0; i < unidadesProducidas; i++) {
                verdGen = verduras[(int) (Math.random()* verduras.length)];
                buffer.Cultivar(verdGen);
                System.out.println("El productor planto: " + verdGen);
                sleep((int) (Math.random() * this.maxTiempoEspera));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }





}
