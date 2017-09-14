package com.company;

import java.awt.*;

/**
 * Created by Computers on 9/1/2016.
 */
public class FractalSet {

    public void julia (double c_real , double c_complex , Graphics g  , double real_lower ,
                       double complex_upper , double real_region , double complex_region) {

        double x1 ,y1;
        for (double y = 0; y<= 800 ; y++) {
            for(double x =0 ; x<=800 ; x++){

                x1 = real_lower    + (x * real_region) / 800;
                y1 = complex_upper - (y * complex_region) / 800;
                //System.out.println(x1);
                // a = 'J';
                double[] z = new double[2];
                double[] square = new double[2];
                double abs;
                int i;
                for ( i = 0; i < 100; i++) {
                    Complex c1 = new Complex(x1, y1);
                    square = c1.square ();
                    z[0] = square[0] + c_real;
                    z[1] = square[1] + c_complex;
                    Complex c2 = new Complex(z[0], z[1]);
                    abs = c2.getAbsolute();

                    if (abs < 2) {
                        x1 = z[0];
                        //System.out.println(x1);
                        y1 = z[1];

                    } else {
                        break;
                    }
                    //System.out.println("i inside the loop[" +x+"]"  +i);

                }
                System.out.println("count[" + x + "] : " + i);


                if (i == 100) {
                    Color myColor = new Color(0, 0, 0);
                    Point p = new Point(x, y, myColor);
                    p.drawPoint(g);
                }else if (i < 3){
                    Color myColor = new Color(0, 0, 153);
                    Point p = new Point(x, y, myColor);
                    p.drawPoint(g);
                }else if(i < 4){
                    Color myColor = new Color(0, 0, 204);
                    Point p = new Point(x, y, myColor);
                    p.drawPoint(g);
                }else if(i<6){
                    Color myColor = new Color(51, 51, 255);
                    Point p = new Point(x, y, myColor);
                    p.drawPoint(g);
                }else if(i<8){
                    Color myColor = new Color(0, 76, 153);
                    Point p = new Point(x, y, myColor);
                    p.drawPoint(g);
                }else if(i < 10){
                    Color myColor = new Color(51, 148, 255);
                    Point p = new Point(x, y, myColor);
                    p.drawPoint(g);
                } else if(i < 20) {
                    Color myColor = new Color(0, 255, 255);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if (i < 40) {
                    Color myColor = new Color(0, 255, 148);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if (i < 60){
                    Color myColor = new Color(102,255, 102);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if (i < 80){
                    Color myColor = new Color(0,255,0);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else {
                    Color myColor = new Color(0, 153, 0);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }
            }
        }
    }


    public void mandelbrot(int iteration , Graphics g , double real_lower ,double complex_upper ,
                           double real_region , double complex_region ) {

        //double[] x = new double[iteration];
        //double[] y = new double[iteration];
        double[] square = new double[2];
        double[] z = new double[2];
        z[0] = 0 ; z[1] = 0;
        double abs;
        double c_real , c_complex;
        int i;
        double x = 0 ; double y = 0;

        for (double y1 = 0; y1<= 800 ; y1++) {
            for(double x1 =0 ; x1<=800 ; x1++){
                c_real    = real_lower    + (x1 * real_region) / 800;
                c_complex = complex_upper - (y1 * complex_region) / 800;

                for ( i = 0; i < iteration; i++) {
                    Complex c1 = new Complex(z[0] , z[1]);
                    square = c1.square();
                    z[0] = square[0] + c_real;
                    z[1] = square[1] + c_complex;
                    Complex c2 = new Complex(z[0] , z[1]);
                    abs = c2.getAbsolute();

                    if(abs >= 2){
                        break;
                    }
                }

                if(i == 100){
                    Color myColor = new Color(0,0,0);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if (i < 20) {
                    Color myColor = new Color(255,0,0);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if(i < 40){
                    Color myColor = new Color(0,255,0);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if(i < 60){
                    Color myColor = new Color(0,0,255);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if(i < 80){
                    Color myColor = new Color(204,204,0);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }else if (i<100){
                    Color myColor = new Color(102,0,102);
                    Point p = new Point(x,y,myColor);
                    p.drawPoint(g);
                }
            }
        }

    }



}
