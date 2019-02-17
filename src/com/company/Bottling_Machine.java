package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

public class Bottling_Machine {
    private Queue<Request> queue=new PriorityQueue<>();
    private  int Size;;
    private  void setSize(int N)
    {
        if(N>9||N<5)
        {
            return;
        }
        Size=N;
    }
    public Bottling_Machine(int N)
    {
        setSize(N);
    }
    public boolean AddRequest(Request request)
    {
        if(queue.size()!=Size) {
            queue.add(request);
            return true;
        }
        return false;
    }
    public double GetTime_Request()
    {
        if(!queue.isEmpty())
        {
            return queue.peek().getTime();
        }
        return 0;
    }

    public  int getSize() {
        return Size;
    }

    public void setQueue(Queue<Request> queue) {
        this.queue = queue;
    }

    public Queue<Request> getQueue() {
        return queue;
    }

    public void RemoveRequest()
    {
        if(!queue.isEmpty())
        {
            System.out.println( queue.peek().getClient().getName()+" "+queue.peek().getClient().getSurname()
                    +" "+queue.peek().getClient().getType()+" "+"has left the station");
            queue.remove();
        }
    }
}