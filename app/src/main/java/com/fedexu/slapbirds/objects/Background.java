package com.fedexu.slapbirds.objects;

import android.graphics.Point;
import android.view.MotionEvent;

import com.fedexu.androidgameengine.GameData;
import com.fedexu.androidgameengine.geom.Polygon;
import com.fedexu.androidgameengine.object.BasicObject;
import com.fedexu.androidgameengine.object.GameObject;

/**
 * Created by Federico on 07/02/18.
 */

public class Background extends GameObject {

    public Background(Point display){
        super();
        this.polygon = new Polygon();

        this.polygon.addPoint(0,0);
        this.polygon.addPoint(display.x, 0);
        this.polygon.addPoint(display.x, display.y);
        this.polygon.addPoint(0, display.y);

        this.setImmovable(true);

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
