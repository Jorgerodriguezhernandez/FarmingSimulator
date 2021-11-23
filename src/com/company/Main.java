package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Huerto huerto = new Huerto(10);
        Granjero p = new Granjero(huerto,9,1000);

        p.start();


        
    }
}
