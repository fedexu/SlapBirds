package com.fedexu.slapbirds.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;

import com.fedexu.androidgameengine.Animation;
import com.fedexu.androidgameengine.GameView;
import com.fedexu.androidgameengine.object.GameObject;
import com.fedexu.slapbirds.R;
import com.fedexu.slapbirds.objects.Cloud;

import java.util.ArrayList;

/**
 * Created by Federico on 05/02/18.
 */

public class MenuView extends GameView {

    /**
     * Create a new view based on the context of the
     * activity and the display size.
     *
     * @param context context of the activity holds this view.
     * @param display display to draw the stuff.
     */
    public MenuView(Context context, Display display) {
        super(context, display);
        gameData.setDebugEnable(true);

        //custom Menu view data
        MenuViewData data = new MenuViewData();
        data.displaySize = this.displeySize;

        gameData.setViewData(data);

        startUpView();
        this.setGameLoopOn(true);
    }

    @Override
    public void onTouch(MotionEvent motionEvent) {

    }

    @Override
    public void update() {

    }

    private void startUpView(){

        //To be created from json

        ArrayList<GameObject> gameObjects = new ArrayList<>();

        Animation animation;
        Bitmap draw;
        Cloud cloud;

        cloud = new Cloud();
        cloud.startCenter = new Point(0 - (int) (this.displeySize.x * 0.2) , (int) (this.displeySize.y * 0.1)  );

        draw = BitmapFactory.decodeResource(this.getResources(), R.drawable.colud1);

        animation = new Animation(draw , 1, 0, 100, 100);

        cloud.addAnimation("IDLE", animation);
        cloud.translate(cloud.startCenter.x, cloud.startCenter.y);

        gameObjects.add(cloud);


        cloud = new Cloud();
        cloud.startCenter = new Point(this.displeySize.x + (int) (this.displeySize.x * 0.2),
                (int) (this.displeySize.y * 0.3)  );

        draw = BitmapFactory.decodeResource(this.getResources(), R.drawable.colud3);

        animation = new Animation(draw , 1, 0, 100, 100);

        cloud.addAnimation("IDLE", animation);
        cloud.setDirectionAngle(180);

        cloud.translate(cloud.startCenter.x, cloud.startCenter.y);

        gameObjects.add(cloud);


        cloud = new Cloud();
        cloud.startCenter = new Point(0 - (int) (this.displeySize.x * 0.2), (int) (this.displeySize.y * 0.5)  );

        draw = BitmapFactory.decodeResource(this.getResources(), R.drawable.colud7);

        animation = new Animation(draw , 1, 0, 100, 100);

        cloud.addAnimation("IDLE", animation);

        cloud.translate(cloud.startCenter.x, cloud.startCenter.y);

        gameObjects.add(cloud);


        cloud = new Cloud();
        cloud.startCenter = new Point(this.displeySize.x  + (int) (this.displeySize.x * 0.2),
                (int) (this.displeySize.y * 0.8)  );

        draw = BitmapFactory.decodeResource(this.getResources(), R.drawable.cumulus_small2);

        animation = new Animation(draw , 1, 0, 100, 100);

        cloud.addAnimation("IDLE", animation);
        cloud.setDirectionAngle(180);
        cloud.translate(cloud.startCenter.x, cloud.startCenter.y);

        gameObjects.add(cloud);

        gameData.getGameObjects().addAll(gameObjects);



        //end to be crated from json



    }
}
