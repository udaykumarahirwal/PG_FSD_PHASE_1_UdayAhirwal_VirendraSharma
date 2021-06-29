package com.lockedme.com;

/**
 * LockedMeExcpetion
 * @author ukumar
 *
 */
public class LockedMeException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public String message;

	public LockedMeException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
