/*******************************************************************************
 * Copyright (c) 2014
 *
 * @author Elisabet Romero Vaquero
 *******************************************************************************/
package screenControl;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public class SplashScreen extends AbstractScreen {
	private Texture splashTexture;
    private Image splashImage;
    
    /**
    * Constructor.
    */
    public SplashScreen() {
            super();
    }
        
    /**
     * Visionado de la pantalla.
     */
    @Override
    public void show() {
        super.show();

        // Load texture
        splashTexture = new Texture("background/startScreen.png");
        
        splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        TextureRegion textureReg = new TextureRegion(splashTexture,512,512);
        TextureRegionDrawable splashRegion = new TextureRegionDrawable(textureReg);
        
        // Inicialize splashImage
        splashImage = new Image(splashRegion, Scaling.stretch);
        splashImage.setFillParent(true);
        
        // Make image transparent
        splashImage.getColor().a = 0f;

        // Add fade-in/out effect of the splashImage
        splashImage.addAction(sequence(fadeIn(0.75f), delay(1.5f), fadeOut(0.75f), new Action() { 
        	@Override        
               public boolean act(float delta) {        
                       // Go to the menu screen
                       game.setScreen(new MenuScreen());
                       return true;
                   } } ));
   
       // Add actor to stage
       stage.addActor(splashImage);
    }               
    
    /**
	 * Libera memoria para eliminar la pantalla.
	 */
	@Override
	public void dispose() {
		splashTexture.dispose();
	}
}
