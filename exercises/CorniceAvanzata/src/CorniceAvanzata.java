
public class CorniceAvanzata 
{
	public CorniceAvanzata() {}
	public void corniceAvanzata(int n, String s)
	{
		int k = 0;
		int z = (int) Math.pow((n-2), 2);
		for (int d=0; d<z; d++)
			s += " ";
		for (int i=0; i<n; i++)
			System.out.print("*");
		System.out.println();
		for (int g = 0; g<n-2; g++)
		{
			System.out.print("*");
			while (k<n-2 && s.length() > 0)
			{
				System.out.print(s.charAt(k));
				k++;
			}
			System.out.print("*");
			System.out.println();
			s = s.substring(k, s.length());
			k = 0;
		}
		for (int i=0; i<n; i++)
			System.out.print("*");
	}
}
