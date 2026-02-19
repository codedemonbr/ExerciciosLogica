package com.codedemonbr;

public class BouncingBall {

    public static int bouncingBall(double h, double bounce, double window) {
        if( h <= 0 || h <= window || bounce <= 0 || bounce >= 1){
            return -1;
        }
        int descidas = 1;
        int subidas = 0;
        while( h > window){

            h = h * bounce;
            ++subidas;
            descidas++;
        }

        return descidas+subidas;
    }
}