package com.chewielouie.textadventure.itemaction;

import com.chewielouie.textadventure.item.Item;
import com.chewielouie.textadventure.Exit;
import com.chewielouie.textadventure.TextAdventureModel;

public class MakeExitVisibleItemAction implements ItemAction {
    private String exitID;
    private TextAdventureModel model;

    public MakeExitVisibleItemAction( String exitID, Item item,
           TextAdventureModel model ) {
        this.exitID = exitID;
        this.model = model;
    }

    public void enact() {
        Exit exit = model.findExitByID( exitID );
        if( exit != null )
            exit.setVisible();
    }
}

