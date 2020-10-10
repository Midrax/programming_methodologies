package it.uniroma1.lcl.level003;

import it.uniroma1.lcl.Constants;
import it.uniroma1.lcl.Direction;
import it.uniroma1.lcl.Level;
import it.uniroma1.lcl.PlayerShip;
import it.uniroma1.lcl.bullets.PlayerBullet;

/**
 * 
 * @author S.S.Rahman
 * 	Una nave che spara tre colpi!
 * 	Progettata per evitare di rimanere schiacciati 
 * 	dai nemici che cadono.
 *
 */
public class TripleShootPlayerShip  extends PlayerShip
{
	public TripleShootPlayerShip(Level l) 
	{
		super(l);
	}

	protected void createShots()
	{
		level.add(new PlayerBullet(level, x+getSpriteWidth()/2-30, y+getSpriteHeight()-25, Constants.DEFAULT_BULLET_SPEED, new Direction(-1, 1)));
		level.add(new PlayerBullet(level, x+getSpriteWidth()/2-5, y+getSpriteHeight()-25));
		level.add(new PlayerBullet(level, x+getSpriteWidth()/2+20, y+getSpriteHeight()-25, Constants.DEFAULT_BULLET_SPEED, new Direction(1, 1)));
	}
}
