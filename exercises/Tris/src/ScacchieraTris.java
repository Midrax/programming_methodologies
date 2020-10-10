
public class ScacchieraTris 
{
	private String[][] scacchiera;
	private static final int righe = 3;
	private static final int colonne = 3;
	public ScacchieraTris()
	{
		scacchiera = new String[righe][colonne];
		for (int i = 0; i < righe; i++)
			for (int j = 0; j < colonne; j++)
			{
				scacchiera[i][j] = " ";
			}
	}
	
	public String toString()
	{
		String r = "";
		for (int i = 0; i < righe; i++)
		{
			for (int j=0; j<colonne ; j++)
				if (j < colonne-1)
					r += scacchiera[i][j] + "|";
				else
					r += scacchiera[i][j];
			r += "\n";
		}
		return r;
	}
	
	public void inserisci(int i, int j, String sign)
	{
		if (scacchiera[i][j] == " ")
			scacchiera[i][j] = sign;
		else
			System.out.println("Casella occupata");
	}
	 
	public String getWinner()
	{
		int k = 0;
		int h = 0;
	    for (int i = 0; i < righe; i++)
	    {
	    	for (int j = 0; j < colonne; j++)
	    	{
	    		if (scacchiera[i][j] == "x")
	    		{
	    			k++;
	    			if (k == 3)
	    			{
	    				return "X WINS, FATALITY!"; 
	    			}
	    		}
	    		else
	    		{
	    			if (scacchiera[i][j] == "o")
	    			{
	    				h++;
	    				if (h==3)
	    				{
	    					return "O WINS, FLAWLESS VICTORY!"; 
	    				}
	    			}
	    		}
	    	}
	    	k=0;
	    	h=0;
	    }
	    
	    for (int i = 0; i < colonne; i++)
	    {
	    	for (int j = 0; j < righe; j++)
	    	{
	    		if (scacchiera[j][i] == "x")
	    		{
	    			k++;
	    			if (k==3)
	    			{
	    				return "X WINS, FATALITY!"; 
	    			}
	    		}
	    		else
	    		{
	    			if(scacchiera[j][i] == "o")
	    			{
	    				h++;
	    				if(h==3)
	    				{
	    					return "O WINS, FLAWLESS VICTORY!"; 
		    				}             
		    			}
		    		}
		    	}
	    		k=0;
	    		h=0;
		    }
	    
		for (int i = 0; i < righe; i++)
		{
		    int j = i;
		    if (scacchiera[i][j] == "x")
		    {
		        k++;
		        if (k==3)
		        {
		        	return "X WINS, FATALITY!"; 
		        }
		    }
		
		    else
		    {
		       if (scacchiera[i][j] == "o")
		       {
		          h++;
		          if (h==3)
		          {
		        	  return "O WINS, FLAWLESS VICTORY!"; 
		          }
		       }
		    }
		}
		k=0;
		h=0;
		int j = 2;
		for (int i = 0; i < righe; i++)
		{
		    if (scacchiera[i][j] == "x")
		    {
		        k++;
		        if (k==3)
		        {
		        	return "X WINS, FATALITY!"; 
		        }
		    }
		    else
		    {
		       if (scacchiera[i][j] == "o")
		       {
		          h++;
		          if(h==3)
		          {
		        	  return "O WINS, FLAWLESS VICTORY!"; 
		          }
		       }
		    }
		    j--;
		}
		return "" ;
	}
}


