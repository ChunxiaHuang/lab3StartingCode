package exceptions;

@SuppressWarnings( "serial" )
public class KeyNotExistException extends Exception
{

	public KeyNotExistException()
	{
		super();
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public KeyNotExistException( String message )
	{
		super( message );
	}
}
