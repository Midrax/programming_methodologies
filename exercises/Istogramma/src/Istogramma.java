public class Istogramma 
{
	private int i;
	private int j;
	private String[] d = new String[j+1];
	public Istogramma(int i, int j) 
	{
		this.i = i;
		this.j = j;	
		this.d = new String[j+1];
		for (int k = i; k<=j; k++)
			d[k] = k+" ";
	}
	public void incrementa(int n)
	{
		String g = ""+n;
		for (int k = i; k<=j; k++)
			{
				if (d[k].substring(0, g.length()).equals(g))
					d[k] += "*";
			}
	}
	
	public void stampa()
	{
		for (int x=0; x<d.length; x++)
			System.out.println(d[x]);
	}
}
