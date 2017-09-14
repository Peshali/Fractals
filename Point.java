package com.company;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Created by Computers on 9/1/2016.
 */
public class Point {

    private double x = 0,y = 0;
    public double[] map_coor = new double[2];

    public Point(double x, double y, Color myNewColor) {
        this.x = x;
        this.y = y;
        this.myNewColor = myNewColor;
    }

    public double[] mapping(double real_lower , double complex_upper , double real_region , double complex_region){

        double x1 = 0, y1 = 0;

        for ( x = 0 , y=0 ; x <= 300 && y <= 300 ; x++ , y++) {

            x1 = real_lower    + (x * real_region) / 300;
            y1 = complex_upper - (y * complex_region) / 300;

        }
        map_coor[0] = x1;
        map_coor[1] = y1;

        return map_coor;
    }

    public static int r,g,b;
    Color myNewColor = new Color(r , g , b);


    public void drawPoint(Graphics g1) {

        Graphics2D g2 = (Graphics2D) g1;
        g2.setColor(myNewColor);
        g2.draw(new Line2D.Double(x,y,x,y));

    }
}
