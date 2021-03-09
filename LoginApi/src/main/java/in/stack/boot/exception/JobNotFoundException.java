package in.stack.boot.exception;

public class JobNotFoundException extends Exception  {
	private String message;
	public JobNotFoundException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
