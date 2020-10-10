package it.uniroma1.lcl.level003;

import it.uniroma1.lcl.Assets;
import it.uniroma1.lcl.Constants;
import it.uniroma1.lcl.Direction;
import it.uniroma1.lcl.Enemy;
import it.uniroma1.lcl.Level;
import it.uniroma1.lcl.bullets.Bullet;
import it.uniroma1.lcl.paths.Path;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class FallingSpaceInvadersEnemy extends Enemy
{
	float speed = 1;
	/**
	 * How much the enemy drops every time the direction is inverted
	 */
	static final float DESCEND_AMOUNT = 6;
	
	/**
	 * When the level has this number of enemies they move the slowest
	 */
	static final float ENEMIES_MAX_NUMBER = 80;
	
	/**
	 * Top border for the different enemies placement
	 */
	static final float ENEMY_PLACEMENT_TOP_BORDER = 420;
	
	/**
	 * Bottom border for the different enemies placement
	 */
	static final float ENEMY_PLACEMENT_BOTTOM_BORDER = 300;
	
	/**
	 * Constructor for the enemy
	 * @param l level
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param d direction
	 */
	public FallingSpaceInvadersEnemy(Level l, float x, float y, Direction d)
	{
		super(l, x, y, d);
		width = hitboxWidth = standardAtlas.getRegions().first().getRegionWidth();
		height = hitboxHeight = standardAtlas.getRegions().first().getRegionHeight();
		chooseSprite();
	}
	
	/**
	 * Constructor for the enemy
	 * @param l level
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param speed speed
	 * @param d direction
	 */
	public FallingSpaceInvadersEnemy(Level l, float x, float y, float speed, Direction d)
	{
		this(l, x, y, d);
		setSpeed(speed);
		chooseSprite();
	}

	/**
	 * Chooses the sprite to use
	 */
	protected void chooseSprite()
	{
		if (y > ENEMY_PLACEMENT_TOP_BORDER)
		{
			standardAtlas = Assets.manager.get(Constants.ENEMY3_ATLAS_PATH, TextureAtlas.class);
			flashAtlas = Assets.manager.get(Constants.ENEMY3_FLASH_ATLAS_PATH, TextureAtlas.class);
		}
		else if (y <= ENEMY_PLACEMENT_TOP_BORDER && y > ENEMY_PLACEMENT_BOTTOM_BORDER)
		{
			standardAtlas = Assets.manager.get(Constants.ENEMY2_ATLAS_PATH, TextureAtlas.class);
			flashAtlas = Assets.manager.get(Constants.ENEMY2_FLASH_ATLAS_PATH, TextureAtlas.class);
		}
		else 
		{
			standardAtlas = Assets.manager.get(Constants.ENEMY1_ATLAS_PATH, TextureAtlas.class);
			flashAtlas = Assets.manager.get(Constants.ENEMY1_FLASH_ATLAS_PATH, TextureAtlas.class);
		}
		
		standardAnim = new Animation(0.04f+rand.nextFloat()/20, standardAtlas.getRegions(), Animation.PlayMode.LOOP);
		flashAnim = new Animation(standardAnim.getFrameDuration() , flashAtlas.getRegions(), Animation.PlayMode.LOOP);
	}
	
	public FallingSpaceInvadersEnemy(Level l, float x, float y, float speed, Path path) {
		super(l, x, y, speed, path);
		width = hitboxWidth = standardAtlas.getRegions().first().getRegionWidth();
		height = hitboxHeight = standardAtlas.getRegions().first().getRegionHeight();
		chooseSprite();
		
	}

	public FallingSpaceInvadersEnemy(Level l, float x, float y, Path path) {
		super(l, x, y, path);
		width = hitboxWidth = standardAtlas.getRegions().first().getRegionWidth();
		height = hitboxHeight = standardAtlas.getRegions().first().getRegionHeight();
		chooseSprite();
	}
	
	public void onCollide(Bullet b)
	{
		isFlashing = true;
		setDirection(Direction.DOWN);
		setSpeed(speed);
		if (Constants.getOptions().getBoolean(Constants.SFX_OPTION) && life==1)
		{
			deathSound.play();
			life--;
		}
	}
	
	@Override
	protected void aliveUpdate(float deltaTime)
	{
		// shoot at random intervals
		if (rand.nextInt(500) < 1+Constants.ENEMY_SHOOT_MODIFIER*(2/level.getEnemies().size())) shoot();
		if (getDirection() == Direction.DOWN)
			{
				speed++;
				setSpeed(speed);
			}
	}
}

