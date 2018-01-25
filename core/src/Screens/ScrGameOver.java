package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Objects.Button;
import Objects.Score;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 *
 * @author johnr5818
 */
// screen 0 is menu and 1 is play
public class ScrGameOver implements Screen {

    Texture txtBack;
    GdxGame game;
    ScrPlay play;
    Button btnRetry;
    Button btnMenu;
    SpriteBatch batch;
    String sScore;
    Score score;
    private BitmapFont font;
    OrthographicCamera oc;

    public ScrGameOver(GdxGame game) {
        this.game = game;

    }

    @Override
    public void show() {
        
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    
        oc.update();
        play=new Screens.ScrPlay(game);
        batch = new SpriteBatch();
        font = new BitmapFont(true);
        font.setColor(Color.BLUE);
        score = new Score(Gdx.graphics.getWidth() / 4 + 150f, Gdx.graphics.getHeight() / 2 - 200, 50f, 50f);
        btnMenu = new Button(590, 0, 50, 40, "menu.png");
        btnRetry = new Button(Gdx.graphics.getWidth() / 2 - 75, Gdx.graphics.getHeight() / 4, 150, 150, "retry.png");

    }

    private void changeScreen() {
       
        if (Gdx.input.justTouched()) {
            if (btnMenu.isMousedOver()) {
                game.updateState(0);
                play.nScore = 0;
            }
            if (btnRetry.isMousedOver()) {
                game.updateState(1);
                 play.nScore = 0;
            }
        }
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        changeScreen();
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        btnMenu.draw(batch);
        score.draw(batch);
        btnRetry.draw(batch);
        
        font.draw(batch,Integer.toString(play.nScore), 400,50);
        batch.end();
       

    }

    @Override
    public void resize(int i, int i1) {
        return;
    }

    @Override
    public void pause() {
        return;
    }

    @Override
    public void resume() {
        return;
    }

    @Override
    public void hide() {
        return;
    }

    @Override
    public void dispose() {
        return;
    }
}
