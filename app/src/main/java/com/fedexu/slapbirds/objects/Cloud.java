package com.fedexu.slapbirds.objects;

import android.graphics.Point;
import android.view.MotionEvent;

import com.fedexu.androidgameengine.GameData;
import com.fedexu.androidgameengine.object.BasicObject;
import com.fedexu.androidgameengine.object.GameObject;
import com.fedexu.slapbirds.views.MenuViewData;

/**
 * Created by Federico on 05/02/18.
 */

public class Cloud extends GameObject {

    public Point startCenter;

    //toBe from json
    public Cloud (BasicObject b){
        super(b);

        this.setSpeed(30);

        this.setImmovable(false);

        this.setUntouchable(true);

        this.setVisible(true);

        this.startCenter = this.getCenter();

    }



    @Override
    public void update(GameData gameData) {

        MenuViewData data = (MenuViewData) gameData.getViewData();

        if(this.getDirectionAngle() == 180 ){
            if(this.getBoundingBox().right < 0)
                this.translateX(startCenter.x);

        }else{
            if(this.getBoundingBox().left > data.displaySize.x)
                this.translateX(startCenter.x);
        }
    }

    @Override
    public void onCollide(GameObject collideObject) {

    }

    @Override
    public void onTouch(GameData gameData, MotionEvent motionEvent) {

    }

}
