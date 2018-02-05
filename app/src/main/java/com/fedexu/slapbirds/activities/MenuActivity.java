package com.fedexu.slapbirds.activities;

import android.view.Display;

import com.fedexu.androidgameengine.GameActivity;
import com.fedexu.androidgameengine.GameView;
import com.fedexu.slapbirds.views.MenuView;

/**
 * Created by Federico Peruzzi.
 *
 */

public class MenuActivity extends GameActivity {

    @Override
    public GameView loadGameView() {

        Display display = getWindowManager().getDefaultDisplay();

        MenuView breackoutView = new MenuView(this, display);

        // MenuView.activity = this;
        return breackoutView;
    }
}
