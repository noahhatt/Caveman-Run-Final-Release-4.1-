package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Objects.Button;
import Objects.Hero;
import Objects.Rock;
import Objects.Score;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.Random;

public class ScrPlay implements Screen {

    GdxGame game;
    Button btnMenu;
    
    SpriteBatch batch;
    boolean bHit;
   
    public static int nScore = 0;
   
    OrthographicCamera oc;
    Score score;
    Hero Hero1;
    Rock Rock;
   
    private BitmapFont font;
    
    Random rand = new Random();
    int nRstart = rand.nextInt(700) + 500;
    float fFallSpeed = 0;

    public ScrPlay(GdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        font = new BitmapFont(true);
        font.setColor(Color.WHITE);
        
        score = new Score(Gdx.graphics.getWidth() / 4 + 75f, Gdx.graphics.getHeight() / 2 - 170, 50f, 50f);
        btnMenu = new Button(590, 0, 50, 40, "menu.png");
        Rock = new Rock(Gdx.graphics.getWidth() / 4 + 500f, Gdx.graphics.getHeight() / 2 + 100, 100f, 100f);
        Hero1 = new Hero(Gdx.graphics.getWidth() / 4 - 50f, Gdx.graphics.getHeight() / 2 + 120, 75f, 75f);
    }

    private void changeScreen() {

        if (Gdx.input.isKeyPressed(Input.Keys.M)) {
            game.updateState(0);

        }
        if (Gdx.input.isKeyPressed(Input.Keys.C)) {
            game.updateState(2);

        }
        if (Gdx.input.justTouched()) {

            if (btnMenu.isMousedOver()) {
                game.updateState(0);
            }
        }
    }

    @Override
    public void render(float f) {
        changeScreen();
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        Hero1.draw(batch);
        Rock.draw(batch);
        btnMenu.draw(batch);
        score.draw(batch);
        font.draw(batch,Integer.toString(nScore), 300, 100);
        
        batch.end();
       


        KeyPressed();

        if (Hero1.getY() >= Gdx.graphics.getHeight() / 2 + 100) {
            fFallSpeed = 0;
        }
        if (Hero1.getY() < Gdx.graphics.getHeight() / 2 + 100) {
            fFallSpeed = fFallSpeed + 0.35f;
            Hero1.setY(Hero1.getY() + fFallSpeed);
        }

      
        bHit = isHit(Hero1, Rock);
        if (bHit == true) {
            System.out.println("Hit Rock");
            game.updateState(3);
            
            
        } else {
            Rock.setX(Rock.getX() - 6);
            if (Rock.getX() <= -200) {
                Rock.setX(nRstart);
                nScore += 1;
       
            System.out.println("jump");
            }
        }

    }

    public void KeyPressed() {
        if (Hero1.getY() >= Gdx.graphics.getHeight() / 2 + 100) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                fFallSpeed = -10;
                Hero1.setY(Hero1.getY() + fFallSpeed);
            }
        }
    }
    //Kieren's awesome code

    public boolean isHit(Hero Hero1, Rock Rock) {
        if (Hero1.getBoundingRectangle().overlaps(Rock.getBoundingRectangle())) {
            return true;
        } else {
            return false;
        }
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