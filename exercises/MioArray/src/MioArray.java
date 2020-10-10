public class MioArray 
{
	private int[] array;
	
	public MioArray(int[] array) 
	{
		this.array = array;
	}
	
	public boolean contiene(int c, int d)
	{
		return array[c] == d;
	} 
	
	public int somma2()
	{
		if (array.length >= 2 )
			return array[0] + array[1];
		if (array.length == 1)
			return array[0];
		else
			return 0;	
	}
	
	public void scambia(int a, int b)
	{
		int x = array[a];
		array[a] = array[b];
		array[b] = x;
	}
	
	public int maxTripla()
	{
		int f = array[0];
		int m = array[(array.length/2)];
		int l = array[(array.length-1)];
		int midmax = Math.max(f,m);
		int max = Math.max(midmax, l);
		return max;
	}
	
	public int[] falloInDue() 
	{
		int[] a = {array[0], array[array.length-1]};
		return a;	
	}
}
