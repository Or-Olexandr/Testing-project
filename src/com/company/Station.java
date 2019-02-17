package com.company;


public class Station {
    private Bottling_Machine station[];
    private double volume_of_day[];
    private double salary = 0;
    private double t_g[];
    private int volume_of_week[];
    private static double price[] = new double[3];

    static {
        price[0] = 35.1;
        price[1] = 31.95;
        price[2] = 30.95;
    }

    private int Number_Client = 0;
    private int Number_Client_Exit = 0;

    private void setVolume_of_day() {
        for (int i = 0; i < volume_of_week.length; i++) {
            this.volume_of_day[i] = this.volume_of_week[i] / 7;
        }
    }

    public Station() {
    }

    private Bottling_Machine getB_M() {
        Bottling_Machine min = station[0];
        for (int i = 0; i < station.length - 1; i++) {
            if (min.getQueue().size() > station[i + 1].getQueue().size()) {
                min = station[i + 1];
            }
        }
        return min;
    }

    public void setStations(int N, int K, double t[]) {
        if (K > 7 || K < 3) {
            return;
        }
        this.station = new Bottling_Machine[K];
        for (int i = 0; i < K; i++) {
            station[i] = new Bottling_Machine(N);
        }
        this.volume_of_week = new int[3];
        for (int i = 0; i < volume_of_week.length; i++) {
            volume_of_week[i] = 0;
        }
        this.volume_of_day = new double[3];
        t_g = new double[3];
        t_g = t;
    }

    public Bottling_Machine[] getStation() {
        return station;
    }

    public void Fill_Request(Request request) {

        Bottling_Machine add = getB_M();
        System.out.println(request.getClient().getName()+" "+request.getClient().getSurname()+" arrived at the gas station");
        if (add.AddRequest(request)) {
            Number_Client++;
            switch (request.getClient().getType()) {
                case A100: {
                    this.volume_of_week[0] += request.getVolume();
                    salary += request.getVolume() * (price[0]*t_g[0]);
                    break;
                }
                case A95: {
                    this.volume_of_week[1] += request.getVolume();
                    salary += request.getVolume() * (price[1]*t_g[1]);
                    break;
                }
                case A92: {
                    this.volume_of_week[2] += request.getVolume();
                    salary += request.getVolume() * (price[2]*t_g[2]);
                    break;
                }

            }
            this.setVolume_of_day();
        } else {
            Number_Client++;
            Number_Client_Exit++;
        }
    }

    public double[] getT_g() {
        return t_g;
    }

    public void ShowQueue()
    {
        for(int i=0;i<station.length;i++)
        {
            System.out.println(i+1+". Bottling Machine: ");
            for(Request re: station[i].getQueue())
            {
               System.out.println(re.getClient().toString()+" Volume: "+re.getVolume()+" Time: "+re.getTime());
            }
        }
    }

    public static double[] getPrice() {
        return price;
    }

    public double getSalary() {
        return salary;
    }

    public int getNumber_Client() {
        return Number_Client;
    }

    public void setStation(Bottling_Machine[] station) {
        this.station = station;
    }

    public double[] getVolume_of_day() {
        return volume_of_day;
    }

    public int getNumber_Client_Exit() {
        return Number_Client_Exit;
    }

    public int[] getVolume_of_week() {
        return volume_of_week;
    }


    public void Handl_Request(double time) {
        if(time<0)
        {
            return;
        }
        for (int j = 0; j < station.length; j++) {
            if (!station[j].getQueue().isEmpty())
                station[j].getQueue().peek().DicreaseTime(time);
        }
        for (int i = 0; i < station.length; i++) {
            if (station[i].GetTime_Request() < 0) {
                double tmp=station[i].GetTime_Request();
                station[i].RemoveRequest();
                Handl_Request(-tmp);
            }
        }
    }
}
