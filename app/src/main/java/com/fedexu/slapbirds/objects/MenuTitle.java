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

    public static int floatingY;

    private int trackY = 0;

    public MenuTitle(BasicObject b){
        super(b);

        this.setImmovable(true);

        this.setUntouchable(true);

        this.setVisible(true);

        this.startCenter = this.getCenter();

        //this.setSpeed(30);

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

        if (trackY > floatingY) {
            this.setDirectionAngle(90);
        }
        if (trackY < 0) {
            this.setDirectionAngle(270);
        }

        if (this.getDirectionAngle() == 90) {
            this.translateY(this.getCenter().y + 1);
            trackY--;
        }
        else{
            this.translateY(this.getCenter().y - 1);
            trackY++;
        }

    }
}
