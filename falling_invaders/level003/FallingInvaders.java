package it.uniroma1.lcl.level003;

import com.badlogic.gdx.graphics.Color;

import it.uniroma1.lcl.*;
import it.uniroma1.lcl.Level.Rank;
import it.uniroma1.lcl.paths.CirclePath;
import it.uniroma1.lcl.paths.LinePath;
import it.uniroma1.lcl.paths.MobiusPath;
import it.uniroma1.lcl.paths.Path.Loop;
import it.uniroma1.lcl.paths.SplinePath.Start;

public class Level003 extends Level
{

	public Level003(WorldController wc) 
	{
		super(wc, "Level 003", "Avoid the falling enemies!", "Ridam S.S. Rahman", Color.LIGHT_GRAY);
	}

	@Override
	protected void init() 
	{
		for (int n = -2; n<2; n++)
			for (int i = -1; i<1; i++)
			{
				add(new FallingSpaceInvadersEnemy(this, Constants.WIDTH/2+n*50-70, 450+i*100, 0, 
						new LinePath(Constants.WIDTH/2+n*50-70, 450+i*100, 4, 0.4f, Start.BEGIN, Loop.FLIP, 1, 150)));
				add(new FallingSpaceInvadersEnemy(this, Constants.WIDTH/2+n*50-70, 500+i*100, 0, 
						new LinePath(Constants.WIDTH/2+n*50-70, 500+i*100, 4, 0.4f, Start.END, Loop.FLIP, 1, 150)));
			}
		add(new FallingEnemy(this, 0, 0, 
				new CirclePath(Constants.WIDTH/2+100, 500, Constants.ENTITY_PATH_SPEED, 0, Start.BEGIN, Loop.RESTART, 100, true)));
		add(new FallingEnemy(this, 0, 0, 
				new CirclePath(Constants.WIDTH/2-100, 500, Constants.ENTITY_PATH_SPEED, 0, Start.END, Loop.RESTART, 100, true)));
		add(new FallingEnemy(this, 0, 0, 
				new MobiusPath(Constants.HEIGHT/2-180, Constants.HEIGHT/2-50, 0.5f, 0, Start.END, Loop.RESTART, 100, 0)));
		add(new FallingEnemy(this, 0, 0, 
				new MobiusPath(Constants.HEIGHT/2-180, Constants.HEIGHT/2-50, 0.5f, 0, Start.BEGIN, Loop.RESTART, 100, 0)));
		add(new Barrier(this, Constants.WIDTH/2-30, 100));
		add(new Barrier(this, 30, 200));
		add(new Barrier(this, Constants.WIDTH-90, 200));
		getPlayer().setPlayerClass(TripleShootPlayerShip.class);
		newPlayer();
	}
	
	@Override
	protected void checkVictoryConditions()
	{
		int i = 0;
		int j = 0;
		for (Enemy e : getEnemies())
		{
			i++;
			if (e.getY() < 0)
				j++;
		}
		if (i==j)
			isComplete = true;
	}
	
	@Override
	protected void checkDefeatConditions()
	{
		if (player.getLives() == 0) isLost = true;
	}

	@Override
	public Rank getRank()
	{
		if (isComplete && player.getLives() == 5) return Rank.S;
		if (isComplete && player.getLives() == 4) return Rank.A;
		if (isComplete && player.getLives() == 3) return Rank.B;
		if (isComplete && player.getLives() == 2) return Rank.C;
		if (isComplete && player.getLives() == 1) return Rank.D;
		else
			return Rank.D;
	}

}
