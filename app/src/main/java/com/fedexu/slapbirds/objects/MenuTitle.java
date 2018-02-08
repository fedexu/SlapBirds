package com.fedexu.slapbirds.objects;

import android.graphics.Point;
import android.view.MotionEvent;

import com.fedexu.androidgameengine.GameData;
import com.fedexu.androidgameengine.object.BasicObject;
import com.fedexu.androidgameengine.object.GameObject;
import com.fedexu.slapbirds.views.MenuViewData;

/**
 * Created by Federico on 07/02/18.
 */

public class MenuTitle extends GameObject {

    public Point startCenter;

    public MenuTitle(BasicObject b){
        super(b);

        this.setImmovable(false);

        this.setUntouchable(true);

        this.setVisible(true);

        this.startCenter = this.getCenter();

        this.setSpeed(60);

        this.setDirectionAngle(270);
    }

    @Override
    public void update(GameData gameData) {
        upDownFloat(gameData);
    }

    @Override
    public void onCollide(GameObject collideObject) {

    }

    @Override
    public void onTouch(GameData gameData, MotionEvent motionEvent) {

    }

    private void upDownFloat (GameData gameData){

        MenuViewData data = (MenuViewData) gameData.getViewData();

        if (this.getCenter().y >  this.startCenter.y ){
            this.setDirectionAngle(90);
            this.comeBack();
        }else
        if (this.getCenter().y <  this.startCenter.y - (data.displaySize.y * 0.05) ){
            this.setDirectionAngle(270);
            this.comeBack();
        }
    }
}
