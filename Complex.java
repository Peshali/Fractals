package com.company;

/**
 * Created by Computers on 9/1/2016.
 */
public class Complex {

    private double x , y;

    public double abs ;
    public double[] square = new double[2];

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public  double getAbsolute (){
        abs = Math.sqrt( (x*x) + (y*y) );
        return abs;
    }

    public double[] square (){
        square[0] = (x*x) - (y*y);
        square[1] = 2*x*y;
        return square;
    }
}
