package example.app.domain.exception;

public class UserAlreadyExistsException extends RuntimeException {

	public UserAlreadyExistsException(String value) {
		super(value);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8110905577266796600L;

}
