package exception;

public class EmptyQueueException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4663501535060153046L;

	public EmptyQueueException() {
        super("Queue is empty");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}