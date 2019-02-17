package com.company;

public class Request implements Comparable{
   private Client client;
   private double volume;
   private double time;

   private void setTime(double volume)
   {
      this.time= volume*0.06;
   }
   public Request(Client client,double volume) {
       if(volume>50||volume<10)
       {
           System.out.println("You entered wrong volume");
           return;
       }
     this.client=client;
     this.volume=volume;
     setTime(volume);
   }
   public Client getClient()
   {
       return this.client;
   }

   public void DicreaseTime(double time)
   {
       this.time-=time;
   }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }


    public double getVolume(){
       return this.volume;
   }
   public double getTime()
   {
       return this.time;
   }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
