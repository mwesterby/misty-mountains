package com.mistymountains;

/**
 * The Mountain class stores the height (m) and name of different mountains
 * 
 * @author (Michael Westerby) 
 * @version 1.0 (08/11/2017)
 */
public class Mountain
{

    private String name;
    private int height;
    
    /**
     * Creates a new mountain with a name and height (m)
     * @param setName   The name of the new mountain
     * @param setHeight The hieght (m) of the new mountain
     */
    public Mountain(String setName, int setHeight)
    {
        name = setName;
        height = setHeight;
    }

    /**
     * Returns the name of a mountain
     * @return  The name of the mountain
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the height of a mountain
     * @return  The height (m) of the mountain
     */
    public int getHeight()
    {
        return height;
    }
    
}
