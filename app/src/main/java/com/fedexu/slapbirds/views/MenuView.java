package com.fedexu.slapbirds.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;

import com.fedexu.androidgameengine.Animation;
import com.fedexu.androidgameengine.EngineUtils;
import com.fedexu.androidgameengine.GameView;
import com.fedexu.androidgameengine.geom.FontCache;
import com.fedexu.androidgameengine.object.BasicObject;
import com.fedexu.androidgameengine.object.GameObject;
import com.fedexu.slapbirds.R;
import com.fedexu.slapbirds.objects.Background;
import com.fedexu.slapbirds.objects.Bird;
import com.fedexu.slapbirds.objects.Cloud;
import com.fedexu.slapbirds.objects.MenuTitle;

import java.util.ArrayList;

import static android.util.Log.*;

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

        //load the pixel font
        //notWorking
        //FontCache.getCachedTypeFace("munro.ttf" , context);

        gameData.setViewData(data);

        startUpView();
        this.setGameLoopOn(true);
    }

    @Override
    public void onTouch(MotionEvent motionEvent) {
        //Log.d("TOUCH", "inizioCicloTouch");
    }

    @Override
    public void update() {
       //Log.d("UPDATE", "inizioCicloUpdate");
    }

    private void startUpView(){

        int cloudRDelay = 160;
        int cloudLDelay = 160;

        ArrayList<GameObject> objects = new ArrayList<>();

        String jsonString = EngineUtils.readJsonfile(getResources().openRawResource(R.raw.menu_view_items));
        BasicObject[] levelElement = EngineUtils.parseJsonString(BasicObject[].class, jsonString);

        for(BasicObject b : levelElement) {
            EngineUtils.pointPercToPointPx(b, this.displeySize);

            if (b.getId() == 1) {
                Background background = new Background(this.displeySize);

                Bitmap backroundImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.gradiente);
                Animation backgroundAnimation = new Animation(backroundImage, 1, 0, displeySize.x, displeySize.y);
                background.addAnimation("BACKGROUND", backgroundAnimation);


                objects.add(background);

            }

            if (b.getId() == 40){

                MenuTitle menuTitle = new MenuTitle(b);

                //Bitmap menuImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_title);
                //Animation menuAnimation = new Animation(menuImage, 1, 0, TOBE, TOBE);
                //menuTitle.addAnimation("MENU_TITLE", menuAnimation);
                menuTitle.floatingY = (int) (displeySize.y * 0.03);
                objects.add(menuTitle);

            }

            if (b.getId() == 60){
                Bird bird = new Bird(b);

                Bitmap birdImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.blue_bird);
                Animation birdAnimation = new Animation(birdImage, 4, 50, 160, 160 );
                bird.addAnimation("FLAP", birdAnimation);

                objects.add(bird);

            }

            if (b.getId() >= 30 && b.getId() <= 39 ){

                Cloud cloud = new Cloud(b);

                Bitmap cloudImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.cumulus_small2);
                Animation cloudAnimation = new Animation(cloudImage, 1, 0, 760, 510 );
                cloud.addAnimation("CLOUD", cloudAnimation);

                cloud.startCenter = new Point(0 - cloudRDelay, cloud.startCenter.y);
                cloudRDelay += cloudRDelay*2;

                cloud.translate(cloud.startCenter.x, cloud.startCenter.y);
                //cloud.setSpeed(50);

                objects.add(cloud);
            }

            if (b.getId() >= 20 && b.getId() <= 29){

                Cloud cloud = new Cloud(b);

                Bitmap cloudImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.cumulus_small3);
                Animation cloudAnimation = new Animation(cloudImage, 1, 0, 640, 410 );
                cloud.addAnimation("CLOUD", cloudAnimation);
                cloud.setDirectionAngle(180);
                cloud.startCenter = new Point(displeySize.x + cloudLDelay, cloud.startCenter.y);
                cloudLDelay += cloudLDelay *2;

                cloud.translate(cloud.startCenter.x, cloud.startCenter.y);

                objects.add(cloud);
            }

        }

        gameData.setGameObjects(objects);

        MenuViewData menuData = new MenuViewData();
        menuData.displaySize = this.displeySize;

        gameData.setViewData(menuData);


    }
}
