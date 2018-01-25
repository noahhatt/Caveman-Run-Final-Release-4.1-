/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author johnr5818
 */
public class Score extends Sprite{
  float fX, fY, fW, fH;
    float fStartX, fStartY;
    public Score(float fX, float fY, float fW, float fH){
        super(new Texture(Gdx.files.internal("Score.psd")));
        setSize(fW, fH);
        setPosition(fX, fY);
        setFlip(false, true);
    }
}
