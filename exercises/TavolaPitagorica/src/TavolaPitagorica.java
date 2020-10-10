public class TavolaPitagorica 
{
	private int n;
	private int tavola[][]  = new int[n][n];
	public TavolaPitagorica(int n) 
	{
		this.n = n;
		int table[][] = new int[n][n];
		for (int a=0; a<n; a++)
		{
			for (int b=0; b<n; b++)
				table[a][b] = a*b;
		}
		this.tavola = table;
	}
	
	public int valueAt(int i, int j)
	{
		return tavola[i][j];
	}
	
	public void stampaTavola()
	{
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				System.out.print(tavola[i][j]+" ");
			}
		System.out.println();
		}
	}
}
