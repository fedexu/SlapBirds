package com.fedexu.slapbirds.objects;

import android.graphics.Point;
import android.view.MotionEvent;

import com.fedexu.androidgameengine.EngineUtils;
import com.fedexu.androidgameengine.GameData;
import com.fedexu.androidgameengine.object.BasicObject;
import com.fedexu.androidgameengine.object.GameObject;
import com.fedexu.slapbirds.views.MenuViewData;

/**
 * Created by Federico on 07/02/18.
 */

public class Bird extends GameObject {

    public boolean idleFlyMoving;

    public Point startCenter;

    public Bird(BasicObject b){
        super(b);

        this.setImmovable(false);

        this.setUntouchable(true);

        this.setVisible(true);

        this.idleFlyMoving = true;

        this.startCenter = this.getCenter();

        this.setSpeed(150);

        this.setDirectionAngle(290);
    }

    @Override
    public void update(GameData gameData) {

        if (idleFlyMoving){
            this.idleFlyMoving(gameData);
        }
    }

    @Override
    public void onCollide(GameObject collideObject) {

    }

    @Override
    public void onTouch(GameData gameData, MotionEvent motionEvent) {

    }

    private void idleFlyMoving(GameData gameData){

        MenuViewData data = (MenuViewData) gameData.getViewData();

        if (this.getCenter().x >  this.startCenter.x + (data.displaySize.x * 0.6)  ) {
            this.setDirectionAngle(180 - this.getDirectionAngle());
            this.comeBack();
            this.getCurrentAnimation().flipBitmap(true, false);
            this.setSpeed(100);
        }else
            if (this.getCenter().x <  this.startCenter.x ){
                this.setDirectionAngle( this.getDirectionAngle() - 180);
                this.comeBack();
                this.getCurrentAnimation().flipBitmap(true, false);
                this.setSpeed(150);
            }

        if (this.getCenter().y >  this.startCenter.y + (data.displaySize.y * 0.1)  ){
            this.setDirectionAngle( - this.getDirectionAngle());
            this.comeBack();
        }else
            if (this.getCenter().y <  this.startCenter.y ){
                this.setDirectionAngle( - this.getDirectionAngle());
                this.comeBack();
            }

    }
}
