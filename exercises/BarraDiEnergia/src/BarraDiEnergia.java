public class BarraDiEnergia 
{
	protected int maxhp;
	protected String hp = "";
	public BarraDiEnergia(int maxhp) 
	{
		this.maxhp = maxhp;
		for (int i=0; i<maxhp; i++)
			hp += "=";
	}
	public void incremento()
	{
		hp = "O"+hp.substring(0, hp.length()-1);
	}
	public String toString()
	{
		return hp;
	}
	public static void main(String[] args)
	{
		BarraDiEnergia e = new BarraDiEnergia(10);
		for (int i=0; i<3; i++)
			e.incremento();
		System.out.println(e);
	}
}
