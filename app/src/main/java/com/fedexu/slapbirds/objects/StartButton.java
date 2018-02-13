package com.fedexu.slapbirds.objects;

import android.graphics.Color;
import android.view.MotionEvent;

import com.fedexu.androidgameengine.GameData;
import com.fedexu.androidgameengine.object.BasicObject;
import com.fedexu.androidgameengine.object.GameObject;
import com.fedexu.androidgameengine.object.TextObject;

/**
 * Created by Federico Peruzzi on 12/02/2018.
 */

public class StartButton extends GameObject{



    public StartButton(BasicObject b){
        super(b);

        this.setImmovable(true);

        this.setUntouchable(true);

        this.setVisible(true);

        this.setShowText(true);


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
