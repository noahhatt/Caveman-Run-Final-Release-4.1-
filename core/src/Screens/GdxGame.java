package Screens;

import com.badlogic.gdx.Game;

public class GdxGame extends Game {

    ScrMenu scrMenu;
    public ScrPlay scrPlay;
    ScrContr scrContr;
    ScrGameOver scrGameOver;
    int nScreen;

   //Thanks Kieran
    
    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        if ( nScreen == 0) {
            setScreen(scrMenu);
        } else if (nScreen == 1) {
            setScreen(scrPlay);
        } else if (nScreen == 2) {
            setScreen(scrContr);
        }
        else if (nScreen == 3) {
            setScreen(scrGameOver);
        } 
    }
    
    @Override
    public void create() {
        nScreen = 0;        
        scrMenu = new ScrMenu(this);
        scrPlay = new ScrPlay(this);
        scrContr = new ScrContr(this);
        scrGameOver = new ScrGameOver(this);
        updateState(0);
        
        
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
