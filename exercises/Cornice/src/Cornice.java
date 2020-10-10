
public class Cornice 
{
	private int n;
	private String s;
	public Cornice(int n, String s) 
	{
		this.n = n;
		this.s = s;
	}
	public String toString()
	{
		String f = "";
		int k = 0;
		int z = (int) Math.pow((n-2), 2);
		for (int d=0; d<z; d++)
			s += " ";
		for (int i=0; i<n; i++)
			f+="*";
		f+="\n";
		for (int g = 0; g<n-2; g++)
		{
			f+="*";
			while (k<n-2 && s.length() > 0)
			{
				f+=(s.charAt(k));
				k++;
			}
			f+="*";
			f+="\n";
			s = s.substring(k, s.length());
			k = 0;
		}
		for (int i=0; i<n; i++)
			f+="*";
		return f;
	}
}
