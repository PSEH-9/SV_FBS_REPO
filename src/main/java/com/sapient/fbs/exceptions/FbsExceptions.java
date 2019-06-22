package com.sapient.fbs.exceptions;

public class FbsExceptions extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;

	public FbsExceptions() {
		this(500);
	}

	public FbsExceptions(int code) {
		this(code, "Error while processing the request", null);
	}

	public FbsExceptions(int code, String message) {
		this(code, message, null);
	}

	public FbsExceptions(int code, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
