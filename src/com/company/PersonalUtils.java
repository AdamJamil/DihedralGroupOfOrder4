package com.company;

public class PersonalUtils
{
    private long time;

    void startTime()
    {
        time = System.nanoTime();
    }

    double printAndReturnTime(String tag)
    {
        double temp = ((System.nanoTime() - time) / (double)1000000000);
        System.out.println(temp + "s " + tag);
        startTime();
        return temp;
    }
}
