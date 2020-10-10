import java.util.Scanner;

public class Tris
{
	public static void main(String[] args)
	{
		int moves = 0;
		String symbol = "x";
	    ScacchieraTris tris = new ScacchieraTris();
	    Scanner input = new Scanner(System.in);
	    while (true)
	    {
	    	System.out.print("inserisci riga per " + symbol);
	    	System.out.println();
	    	int riga = input.nextInt();
	    	System.out.print("Inserisci colonna per " + symbol);
	    	System.out.println();
	    	int colonna = input.nextInt();
	    	tris.inserisci(riga, colonna, symbol);
	    	System.out.println(tris.toString());
	    	String result = tris.getWinner();
	    	if (result.equals("X WINS, FATALITY!") || result.equals("O WINS, FLAWLESS VICTORY!"))
	    	{
	    		System.out.println(result);
	    		return;
	    	}
	    	moves++;
	    	if (moves == 9)
	    	{
	            System.out.println("Pareggio!");
	            return;
	    	}
	    	if (symbol == "x") 
	    		symbol = "o";
	    	else 
	    		symbol = "x";
	    }
	}
}