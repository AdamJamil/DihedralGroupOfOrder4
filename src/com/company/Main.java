package com.company;

import java.util.Set;

public class Main
{

    Main()
    {
        SubGroups D4 = new SubGroups();

        Element r0 = new Element(new int[]{1, 2, 3, 4});
        Element r1 = new Element(new int[]{4, 1, 2, 3});
        Element r2 = r1.apply(r1);
        Element r3 = r2.apply(r1);
        Element f0 = new Element(new int[]{4, 3, 2, 1});
        Element f1 = r1.apply(f0);
        Element f2 = r2.apply(f0);
        Element f3 = r3.apply(f0);

        Group g = new Group();
        g.add(r0, r1, r2, r3, f0, f1, f2, f3);

        for (Set<Element> temp : SubGroups.powerSet(g.elements))
        {
            Group temp2 = new Group();
            temp2.elements = temp;
            if (temp2.isGroup())
                D4.add(temp2);
        }

        System.out.println(D4.groups);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}