package com.company;

import java.util.*;

class Group
{
    Set<Element> elements = new HashSet<>();

    void add(Element... element)
    {
        elements.addAll(Arrays.asList(element));
    }

    boolean isGroup()
    {
        return containsIdentity() && closed() && containsInverse();
    }

    boolean containsIdentity()
    {
        return elements.contains(new Element(new int[]{1, 2, 3, 4}));
    }

    boolean containsInverse()
    {
        Element identity = new Element(new int[]{1, 2, 3, 4});
        for (Element temp1 : elements)
        {
            boolean inverseFound = false;
            for (Element temp2 : elements)
                if (temp1.apply(temp2).equals(identity) && temp2.apply(temp1).equals(identity))
                    inverseFound = true;
            if (!inverseFound)
                return false;
        }
        return true;
    }

    boolean closed()
    {
        for (Element temp1 : elements)
            for (Element temp2 : elements)
                if (!elements.contains(temp1.apply(temp2)))
                    return false;
        return true;
    }

    @Override
    public String toString()
    {
        String output = "{\n";
        for (Element element : elements)
            output += "\t" + element + "\n";
        output += "}";
        return output;
    }

    @Override
    public int hashCode()
    {
        int sum = 0;
        for (Element temp : elements)
            sum += temp.hashCode();
        return sum;
    }

    @Override
    public boolean equals(Object obj)
    {
        Group that = (Group) obj;
        for (Element temp : elements)
            if (!that.elements.contains(temp))
                return false;
        return true;
    }
}