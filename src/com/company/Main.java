package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
         int N = 0;
         int K =0;
         int answer=0;
        double t_g[] = new double[3];
        boolean m=true;
        Scanner in= new Scanner(System.in);
        System.out.println("Welcome to model of station!!!");
        System.out.println("For continue enter data:");
        for(int i=0;i<t_g.length;i++)
        {
            m=true;
            while (m)
            {
                System.out.println("Entered trading margin(0.05-0.15): ");
                System.out.println(Type.values()[i]);
                try{
                    t_g[i]=in.nextDouble();
                    if(t_g[i]>0.15||t_g[i]<0.05)
                    {
                        System.out.println("You entered wrong trading margin");
                        continue;
                    }
                    m=false;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered wring number!");
                    in.next();
                    m=true;
                }

            }
        }
        m=true;

        while (m)
        {
            System.out.println("Entered queue length(5-9): ");
            try{
                N=in.nextInt();
                if(N>9||N<5)
                {
                    System.out.println("You entered wrong number!");
                    continue;
                }
                m=false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("You entered wrong number!");
                in.next();
                m=true;
            }

        }
        m=true;
        while (m)
        {
            System.out.println("Entered number of bottling machines(3-7): ");
            try{
                K=in.nextInt();
                if(K>7||K<3)
                {
                    System.out.println("You entered wrong number!");
                    continue;
                }
                m=false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("You entered wrong number!");
                in.next();
                m=true;
            }

        }

        Station s = new Station();
        s.setStations(N, K, t_g);
        ShowStation show = new ShowStation(s);
        RandomRequest rand = new RandomRequest(s);

        m=true;
        while (m)
        {
            System.out.println("Entered number step(10-60): ");
            try{
               rand.setStep_of_work(in.nextInt());
                m=false;
                if(rand.getStep_of_work()>60||rand.getStep_of_work()<10)
                {
                    System.out.println("You entered wring number!");
                    m=true;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("You entered wring number!");
                in.next();
                m=true;
            }

        }
        for (int i = 0; i < 7; i++) {
            rand.Create_Request(i);
        }
        System.out.println(show.toString());
        show.Show_Volume_of_week();
        show.Show_Volume_of_day();

        m=true;
        while (m)
        {
            System.out.println( "Write to file?\n"+"1.Yes   2.No");
            try{
                 answer=in.nextInt();
                m=false;
                if(answer>2||answer<1)
                {
                    System.out.println("You entered wring number!");
                    m=false;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("You entered wring number!");
                in.next();
                m=true;
            }

        }
        if(answer==1) {
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("TestAutostation.txt",true)));
                out.println("###################################################");
                out.write("Queue length: "+s.getStation()[0].getSize()+"\r\n");
                out.write("Number of bottling machines: "+s.getStation().length+"\r\n");
                for(int i=0;i<t_g.length;i++)
                {
                    out.println(Type.values()[i]+" :"+t_g[i]);
                }
                out.println(show.toString());
                out.println("Average gasoline volume sold per week: ");
                for(int i=0;i<s.getVolume_of_week().length;i++){
                   out.println(Type.values()[i] + ": "+s.getVolume_of_week()[i]);
                }
                out.println( "Average gasoline volume sold per day: ");
                for(int i=0;i<s.getVolume_of_day().length;i++){
                    out.println(Type.values()[i] + ": "+s.getVolume_of_day()[i]);
                }
                out.println("###################################################");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        in.close();

    }
}