package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Main extends JPanel {

    //set width and height of a JPanel
    private static int WIDTH = 800;
    private static int HEIGHT = 800;

    public static char a , b ;

    private static ArrayList<Shape> listOfShapes;   //creating array list to put shapes


    public static int length;
    public static double real_low_int;
    public static double real_upper_int;
    public static double complex_low_int;
    public static double complex_upper_int;
    public static double c_real;
    public static double c_complex;
    public static int iterations;
    public static double real_region;
    public static double complex_region;
    public static double[] map_coor_J = new double[2];
    public static double[] map_coor_M = new double[2];

   // public static FractalSet j  =new FractalSet();
    public static FractalSet MB = new FractalSet();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Some Shapes");    //set title

        frame.setContentPane(new Main());
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setSize(WIDTH, HEIGHT);
        frame.pack();
        frame.setVisible(true);

        length = args.length;

        real_low_int = -1;
        real_upper_int = 1;
        complex_low_int = -1;
        complex_upper_int = 1;
        iterations = 1000;

        Point p = new Point();

        if(args[0].equals("Julia")){

            real_region    = real_upper_int - real_low_int;
            complex_region = complex_upper_int - complex_low_int;
            if(length ==1){
                c_real = -0.4;
                c_complex = 0.6;
            }else if(length == 3){
                c_real = Double.parseDouble(args[1]);
                c_complex = Double.parseDouble(args[2]);
            }else{
                System.out.println("Wrong input argument");
            }

            //a = 'J';
           // map_coor_J = p.mapping (real_low_int , complex_upper_int , real_region , complex_region);


        }else if(args[0].equals("Mandelbrot")){

            if (length ==1){
                real_region    = real_upper_int - real_low_int;
                complex_region = complex_upper_int - complex_low_int;
                map_coor_M = p.mapping(real_low_int , complex_upper_int , real_region , complex_region);

                c_real = map_coor_M[0];
                c_complex = map_coor_M[1];
            }else if(length == 5 || length == 6){
                real_low_int = Double.parseDouble(args[1]);
                real_upper_int = Double.parseDouble(args[2]);
                complex_low_int = Double.parseDouble(args[3]);
                complex_upper_int = Double.parseDouble(args[4]);

                real_region    = real_upper_int - real_low_int;
                complex_region = complex_upper_int - complex_low_int;
                map_coor_M = p.mapping(real_low_int , complex_upper_int , real_region , complex_region);

                c_real    = map_coor_M[0];
                c_complex = map_coor_M[1];
                if(length == 6){
                    iterations = Integer.getInteger(args[5]);
                }
            }

            b = 'M';


        } else{
                System.out.println("Wrong input argument");
        }


        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        FractalSet j  =new FractalSet();
        if(a == 'J'){
            j.julia( c_real , c_complex ,g , a , real_low_int , complex_upper_int , real_region , complex_region);
        }else{
            if(b == 'M'){
                MB.mandelbrot(iterations , c_real , c_complex , g , b);
            }
        }
    }

}

