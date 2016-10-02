package custExceptions;

public class BasePriceMissingException extends Exception{
	private static final long serialVersionUID = 4938117690366171986L;

	public BasePriceMissingException(String s) {
		super(s);
	}

	public double fixBasePrice()
	{
		return 0.0;
	}
}
