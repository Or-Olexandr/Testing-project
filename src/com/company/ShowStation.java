package com.company;

import com.sun.org.apache.regexp.internal.RE;

public class ShowStation {
    private Station station;
    public ShowStation(Station station)
    {
        this.station=station;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }


    public void Show_Volume_of_week()
    {
        System.out.println( "Average gasoline volume sold per week: ");
        for(int i=0;i<station.getVolume_of_week().length;i++){
            System.out.println(Type.values()[i] + ": "+station.getVolume_of_week()[i]);
        }
    }

    public void Show_Volume_of_day()
    {
        System.out.println( "Average gasoline volume sold per day: ");
        for(int i=0;i<station.getVolume_of_day().length;i++){
            System.out.println(Type.values()[i] + ": "+station.getVolume_of_day()[i]);
        }
    }

    @Override
    public String toString() {
        return "\r\nAmount Client: "+station.getNumber_Client()+"\r\nThe number of client that left:"+station.getNumber_Client_Exit()
                +"\r\nAmount Salary: "+station.getSalary();

    }
}