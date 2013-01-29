package com.chewielouie.textadventure;

import java.util.List;

public interface TextAdventureModel {
    public String currentLocationDescription();
    public List<Exit> currentLocationExits();
    public void moveThroughExit( String exitLabel );
}
