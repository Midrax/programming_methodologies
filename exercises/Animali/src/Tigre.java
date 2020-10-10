public class Tigre extends Felino
{
	public Tigre() {}
	@Override
	void emettiVerso() 
	{
		System.out.println("Roar!");
	}

	@Override
	void getNumeroDiZampe() 
	{
		System.out.println(4);
	}
	@Override
	void getTaglia() 
	{
		System.out.println("Grande");
	}

}
