
public class BarraDiEnergiaConPercentuale extends BarraDiEnergia
{

	public BarraDiEnergiaConPercentuale(int maxhp) 
	{
		super(maxhp);
	}
	public String toString()
	{
		int n = 0;
		double prc = 100/maxhp;
		for (int i = 0; i<maxhp; i++)
			if (Character.toString(hp.charAt(i)).equals("O"))
				n++;
		prc = prc*n;
		return hp+" "+Double.toString(prc)+"%";
	}
	public static void main(String[] args) 
	{
		BarraDiEnergiaConPercentuale b = new BarraDiEnergiaConPercentuale(10);
		for (int i=0; i<3; i++)
			b.incremento();
		System.out.println(b);
	}
}
