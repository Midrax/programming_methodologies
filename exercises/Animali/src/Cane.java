
public class Cane extends Mammifero
{
	public Cane() {}
	@Override
	void emettiVerso() 
	{
		System.out.println("Bau!");
	}

	@Override
	void getNumeroDiZampe() 
	{
		System.out.println(4);
	}
	@Override
	void getTaglia() 
	{
		System.out.println("Media");
	}
}
