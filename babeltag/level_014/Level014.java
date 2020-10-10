package it.uniroma1.lcl.babeltag.level014;


import java.util.ArrayList;
import java.util.List;

import it.uniroma1.lcl.babeltag.Assets;
import it.uniroma1.lcl.babeltag.Constants;
import it.uniroma1.lcl.babeltag.Level;
import it.uniroma1.lcl.babeltag.WorldController;
import it.uniroma1.lcl.saga.api.AnnotationManager;
import it.uniroma1.lcl.saga.api.Callback;
import it.uniroma1.lcl.saga.api.MainThreadCallback;
import it.uniroma1.lcl.saga.api.TaskConfiguration;
import it.uniroma1.lcl.saga.api.exceptions.AuthenticationRequiredException;
import it.uniroma1.lcl.saga.task.TaskType;
import it.uniroma1.lcl.saga.task.job.answer.StringAnswer;
import it.uniroma1.lcl.saga.task.job.selection.SelectionWithinTextJob;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Level 014: Analisi logica
 *
 * -Il giocatore deve selezionare le parole corrispondenti alla parte logica mostrata
 * -Ogni parte logica “dura” qualche secondo, sempre meno a ogni frase mostrata
 * ￼-La selezione avviene toccando le parole
 * -Toccando la parte logica si passa alla prossima
 * -Terminato il tempo o una serie di n tag si conclude la partita
 *
 * @author S. Sakib Rahman
 *
 */
public class Level014 extends Level
{
	/**
	 * The TextureAtlas with the interface elements
	 */
	protected TextureAtlas interfaceAtlas = Assets.manager.get(Constants.INTERFACE_ATLAS_PATH, TextureAtlas.class);
	
	private Texture time = new Texture(Gdx.files.internal(Constants.TIME_ICON_PATH));
	
	/**
	 * The syntactical part that's requested, obtainable through the query
	 */
	private List<StringAnswer> ansCon;
	
	private TaskConfiguration config;
	
	/**
	 * The text that has to be analyzed
	 */
	private String text;
	
	/**
	 * Variables needed to manage the arc
	 */
	private float fill = 360;
	private float increaseValue = 0.2f;
	
	private int wordNumber;
	private int nextInt = 0;
	private int mill = 0;
	private int seconds = 0;
	private int minutes = 0;
	private boolean nowRender = false;
	private boolean refiller = false;	
	
	private ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	private Sound correct = Assets.manager.get(Constants.CORRECT_SOUND_PATH, Sound.class);
	private Sound select1 = Assets.manager.get(Constants.SELECT1_SOUND_PATH, Sound.class);
	private Sound select2 = Assets.manager.get(Constants.SELECT2_SOUND_PATH, Sound.class);
	private Sound select3 = Assets.manager.get(Constants.SELECT3_SOUND_PATH, Sound.class);
	
	/**
	 * The Labels' list, containing all the words from the text
	 */
	private List<Label> labelList = new ArrayList<Label>();
	
	public Level014(WorldController wc)
	{
		super(wc, "Syntactic Analysis!", "Syntactically analyze the phrases!", "Ridam S.S. Rahman", Constants.GRAY);
		// Generates an empty orange button, the word inside it is created through render
		createSyntacticalButton();
		createNextButton();
	}

	@Override
	protected void checkFinishConditions()
	{
		if (nowRender)
			if (nextInt>=ansCon.size())
				isOver = true;
			
	}

	@Override
	protected void init()
	{		
		config = new TaskConfiguration(TaskType.SYNTACTIC_ANALYSIS);
		config.setLanguage(getLanguage());
		
		final LabelStyle style = new LabelStyle();
        style.font = new BitmapFont(Gdx.files.internal(Constants.FONT_PATH));
        style.font.setScale(0.6f);
		
        try
		{
			AnnotationManager.getInstance().getData(config, new MainThreadCallback<SelectionWithinTextJob>() 
			{
				@Override
				public void onSuccess(SelectionWithinTextJob result) 
				{
					nowRender = true;
					text = result.getText();
					String[] wordList = text.split(" ");
					wordNumber = text.split(" ").length;
					ansCon = result.getAnswerContainers();
					for (int i=0; i<wordNumber; i++)
					{
			    		labelList.add(new Label(wordList[i], style));
				    	final Label lab = labelList.get(i);
			    		lab.addListener(new InputListener() 
			    		{
			    			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
			    		    {
			    				if (lab.getColor().equals(new Color(255,255,255,1)))
			    				{
			    					select2.play();
			    					lab.setColor(Constants.ORANGE);
			    				}
			    				else
			    				{
			    					select3.play();
			    					lab.setColor(255,255,255,1);
			    				}
			    	            return true;
			    		    }
			    		});
			    	}
			    	
			    	labelList.get(0).setPosition(10, 450);
			    	mainStage.addActor(labelList.get(0));
					for (int i=1; i<wordNumber; i++)
					{
						float width = labelList.get(i-1).getWidth()+labelList.get(i-1).getX()+20;
						float height = labelList.get(i-1).getY();
						if (width+labelList.get(i).getWidth() < Constants.WIDTH)
							labelList.get(i).setPosition(width, height);
						else
						{
							width = 10;
							height = labelList.get(i-1).getY()-60;
							labelList.get(i).setPosition(width, height);
						}
						mainStage.addActor(labelList.get(i));
					}
					
				}
				
				@Override
				public void onFailure(Throwable cause) 
				{
					handleCallbackFailure();
				}

				@Override
				public void onFailureInMainThread(Throwable cause)
				{
				}

				@Override
				public void onSuccessInMainThread(SelectionWithinTextJob result) {
					
				}
			});
			
		} 
		catch (AuthenticationRequiredException e)
		{
			System.err.println("You have to be logged in!");
		}
	}
	
	@Override
	protected void removeDeadEntities()
	{
	}
	
	@Override
	public void render(SpriteBatch batch)
	{	
		shapeRenderer.setProjectionMatrix(worldController.getCamera().combined);
		shapeRenderer.begin(ShapeType.Filled);
		if (fill>90)
			shapeRenderer.setColor(Constants.DARK_TEAL);
		if (fill<=90)
			shapeRenderer.setColor(Constants.RED);
		shapeRenderer.arc(Constants.WIDTH/2, Constants.HEIGHT/2+250, 120, 90, fill, 360);
		shapeRenderer.end();

		super.render(batch);		
		batch.begin();
		
		if (nowRender)
		{
			if (fill>0)
				fill-=increaseValue;
			else
			{
				nextInt++;
				fill = 360;
				increaseValue = increaseValue*1.5f;
				for (int i = 0; i<wordNumber; i++)
					if (labelList.get(i).getColor().equals(Constants.ORANGE))
						labelList.get(i).setColor(255, 255, 255, 1);
			}
			if (nextInt<ansCon.size())
			{
				font.draw(batch, ansCon.get(nextInt).getQuery(), Constants.WIDTH/2-ansCon.get(nextInt).getQuery().length()*8-1, Constants.HEIGHT/2+260);
				if (refiller)
				{
					fill = 360;
					refiller = false;
				}
			}
		}
		else
			font.draw(batch, "LOADING", Constants.WIDTH/2-55, Constants.HEIGHT/2+260);
		batch.draw(interfaceAtlas.findRegion("skip_big"), 0, 0);
		batch.draw(time, Constants.WIDTH/2-60, 15);
		String second = seconds+"";
		if (second.length()<2)
			second = "0"+second;
		font.draw(batch, minutes+" : "+second+"", Constants.WIDTH/2, 45);
		batch.end();
	}
	
	@Override
	public void update(float deltaTime)
	{
		mainStage.act(deltaTime);
		if (mill<60)
			mill++;
		else
		{
			mill = 0;
			if (seconds<60)
				seconds++;
			else
			{
				seconds = 0;
				minutes++;
			}
		}
		checkFinishConditions();
	}
		
	/**
	 * Creates a button using Button class and mainStage
	 */
	private void createSyntacticalButton()
	{
        Skin buttonSkin = new Skin();
        buttonSkin.addRegions(interfaceAtlas); 
        
        //create the style for the button
        ButtonStyle style = new ButtonStyle();
        style.up = buttonSkin.getDrawable("circle_button_orange");
        style.down = buttonSkin.getDrawable("circle_button_orange_pressed");
        
        Button button = new Button(style); 
		button.setPosition(Constants.WIDTH/2-100, Constants.HEIGHT/2+150);
		button.setHeight(200); 
		button.setWidth(200);
		button.addListener(new InputListener() 
		{
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
		    {
				try 
				{
					String answer = "";
					for (int i = 0; i<wordNumber; i++)
						if (labelList.get(i).getColor().equals(Constants.ORANGE))
						{
							answer+=labelList.get(i).getText()+" ";
							labelList.get(i).setColor(Constants.DARK_TEAL);
						}
					if (answer.length() > 0)
					{
						answer = answer.substring(0, answer.length()-1);
						ansCon.get(nextInt).addAnswer(answer);
						AnnotationManager.getInstance().sendAnnotation(config, ansCon.get(nextInt), new Callback<Float>()
						{
	
							@Override
							public void onSuccess(Float result) 
							{
								nextInt++;
								refiller = true;
								increaseValue = increaseValue*1.5f;
								worldController.getPlayer().addScore(result);
								if (result>=1)
									correct.play();
								else
									select1.play();
							}
							@Override
							public void onFailure(Throwable cause) 
							{
								handleCallbackFailure();
							}
							
						});
					}
					else
					{
						select1.play();
						nextInt++;
						refiller = true;
						increaseValue = increaseValue*1.5f;
					}
				} 
				catch (AuthenticationRequiredException e) 
				{
					e.printStackTrace();
				}
				return true;
		    }
		});
		mainStage.addActor(button);
	}
	
	private void createNextButton()
	{
        Skin buttonSkin = new Skin();
        buttonSkin.addRegions(interfaceAtlas); 
        
        //create the style for the button
        ButtonStyle style = new TextButtonStyle();
        style.up = buttonSkin.getDrawable("skip_big");
        
        //create the actual button with position, name, and a listener for actions
        Button button = new Button(style); 
		button.setPosition(0, 0);
		button.addListener(new InputListener() {
		    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
		    {
		    	if (Constants.getOptions().getBoolean(Constants.SFX_OPTION)) clickSound.play();
		    	nextInt++;
		    	fill = 360;
		    	for (int i = 0; i<wordNumber; i++)
					if (labelList.get(i).getColor().equals(Constants.ORANGE))
					{
						labelList.get(i).setColor(255, 255, 255, 1);
					}
		    	return true;
		    }
		  });
		
		//add the button to the mainStage
		mainStage.addActor(button);
	}
}


