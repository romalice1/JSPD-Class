package custExceptions;

import java.io.FileNotFoundException;

public class InvalidFileException extends FileNotFoundException{
	private static final long serialVersionUID = -2042390188026311197L;
	
	public InvalidFileException(String s)
	{
		super(s);
	}
	public String fixFile()
	{
		return "prius.txt";
	}
}
