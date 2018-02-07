package com.fedexu.slapbirds.objects;

import android.view.MotionEvent;

import com.fedexu.androidgameengine.GameData;
import com.fedexu.androidgameengine.object.BasicObject;
import com.fedexu.androidgameengine.object.GameObject;

/**
 * Created by Federico on 07/02/18.
 */

public class MenuTitle extends GameObject {

    public MenuTitle(BasicObject b){
        super(b);

        this.setImmovable(false);

        this.setUntouchable(true);

        this.setVisible(true);
    }

    @Override
    public void update(GameData gameData) {

    }

    @Override
    public void onCollide(GameObject collideObject) {

    }

    @Override
    public void onTouch(GameData gameData, MotionEvent motionEvent) {

    }
}
