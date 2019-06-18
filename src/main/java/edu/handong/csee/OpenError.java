package edu.handong.csee;

public class OpenError extends Exception {

	public OpenError() {
		super("Hi, I am an error. You have some problems to solve ;)");
	}
	
	public OpenError(String message) {
		super(message);
	}
	
}
