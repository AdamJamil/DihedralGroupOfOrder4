package com.company;

import java.util.HashSet;
import java.util.Set;

class Element
{
    int[] map;

    Element(int[] map)
    {
        this.map = map;
    }

    Element apply(Element input)
    {
        Element output = new Element(new int[]{0, 0, 0, 0});
        output.map[0] = input.map[this.map[0] - 1];
        output.map[1] = input.map[this.map[1] - 1];
        output.map[2] = input.map[this.map[2] - 1];
        output.map[3] = input.map[this.map[3] - 1];
        return output;
    }

    @Override
    public String toString()
    {
        return "(" + map[0] + ", " + map[1] + ", " + map[2] + ", " + map[3] + ")";
    }

    @Override
    public boolean equals(Object o)
    {
        Element that = (Element) o;
        return (map[0] == that.map[0]) && (map[1] == that.map[1]) && (map[2] == that.map[2]);
    }

    @Override
    public int hashCode()
    {
        return (map[0] * 100) + (map[1] * 10) + map[2];
    }
}