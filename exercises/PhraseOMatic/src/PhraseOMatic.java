public class PhraseOMatic 
{
	public static void main(String[] args) 
	{
		String[] I1 = { "salve", "ciao", "hello", "buongiorno", "scialla" };
		String[] I2 = { "egregio", "eclettico", "intelligentissimo", "astutissimo" };
		String[] I3 = { "studente", "ragazzo", "giovane", "scapestrato", "fannullone", "studioso"};
		double r1 = Math.random();
		double r2 = Math.random();
		double r3 = Math.random();
		r1 = r1*5;
		r2 = r2*4;
		r3 = r3*6;	
		String a = I1[(int) r1];
		String b = I2[(int) r2];
		String c = I3[(int) r3];
		System.out.println(a+" "+b+" "+c);
	}
}
