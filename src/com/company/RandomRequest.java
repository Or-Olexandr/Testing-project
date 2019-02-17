package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomRequest {
    private Station station;
    private static int step=1;
    private  int step_of_work;
    private static int Duration_Day=1440;
    private static final String name[]=new String[]{"Olexandr","Bogdan","Eduard","Oleg","Yaroslav","Dima","Mikola"};
    private static final String surname[]=new String[]{"Petrov","Sidorov","Kuchko","Kirilyuk"};
    public RandomRequest(Station station)
    {
        this.station=station;
    }
    public void Create_Request(int Day) {
        double procent;
        double t_g =(station.getT_g()[0]+station.getT_g()[1]+station.getT_g()[2])/3;
        if((t_g>0.07)&&(t_g<0.11)) {
             procent= ((0.23-t_g)/2*100);
        }
        else {
            if(t_g>0.1&&t_g<0.14)
            {
                procent= ((0.233-t_g)/2*100);
            }
            else {
                procent = (0.25 - t_g) / 2 * 100;
            }
        }
        double quick;
        Random rand = new Random();
        if (Day < 5) {
            quick=1;

        } else {
            quick=2;
        }
        for(int j=1;j<Duration_Day;j+=step){
            boolean m=true;
            Scanner in=new Scanner(System.in);
            int choose;
            if(j%this.step_of_work==0)
            {
                while (m)
                {
                    System.out.println("1. Continue.\n"+"2. Show Queue.\n"+"3. Stop.\n"+"4. Continue without stop.");
                    try{
                        choose=in.nextInt();
                        switch (choose)
                        {
                            case 1:
                            {
                                m=false;
                                break;
                            }
                            case 2:
                            {
                                station.ShowQueue();
                                m=true;
                                break;
                            }
                            case 3:
                            {
                                j=1440;
                                RandomRequest.Duration_Day=0;
                                m=false;
                                break;
                            }
                            case 4:
                            {
                                this.step_of_work=1440;
                                m=false;
                                break;
                            }
                            default:
                            {
                                System.out.println("You entered wrong number!");
                                m=true;
                                break;
                            }
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered wrong number!");
                        in.next();
                        m=true;
                    }

                }
            }

            if (j / 740 == 1 && j % 740 < 120||(j/740>360&&j/740<480)) {
                step = (int) ((rand.nextInt(3) * quick*procent*t_g));
            } else {
                step = (int) ((rand.nextInt(20) * quick * procent * t_g));
            }
            Client cl = new Client(
                    name[rand.nextInt(name.length)],
                    surname[rand.nextInt(surname.length)],
                    Type.values()[rand.nextInt(Type.values().length)]);
            Request re = new Request(cl, rand.nextInt(40) + 10);
            station.Handl_Request(step);
            station.Fill_Request(re);
        }
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public static int getDuration_Day() {
        return Duration_Day;
    }

    public static int getStep() {
        return step;
    }

    public static void setStep(int step) {
        RandomRequest.step = step;
    }

    public static String[] getName() {
        return name;
    }

    public static String[] getSurname() {
        return surname;
    }

    public int getStep_of_work() {
        return step_of_work;
    }

    public void setStep_of_work(int step_of_work) {
        this.step_of_work = step_of_work;
    }
}

