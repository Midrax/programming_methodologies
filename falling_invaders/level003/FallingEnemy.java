package it.uniroma1.lcl.level003;

import com.badlogic.gdx.utils.Timer;

import it.uniroma1.lcl.Constants;
import it.uniroma1.lcl.Direction;
import it.uniroma1.lcl.Enemy;
import it.uniroma1.lcl.Level;
import it.uniroma1.lcl.LivingEntity.State;
import it.uniroma1.lcl.bullets.Bullet;
import it.uniroma1.lcl.paths.Path;

/**
 * 
 * @author S.S. Rahman
 *	In breve, questo è un nemico "invulnerabile", 
 *	una volta che viene colpito precipita, 
 *	e non può essere fermato. 
 *
 */
public class FallingEnemy extends Enemy
{
	float speed = 1;
	int life = 1;
	public FallingEnemy(Level l, float x, float y, Direction d) {
		super(l, x, y, d);
		
	}
	public FallingEnemy(Level l, float x, float y, float speed, Direction d) {
		super(l, x, y, speed, d);
	}

	public FallingEnemy(Level l, float x, float y, float speed, Path path) {
		super(l, x, y, speed, path);
		
	}

	public FallingEnemy(Level l, float x, float y, Path path) {
		super(l, x, y, path);
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
