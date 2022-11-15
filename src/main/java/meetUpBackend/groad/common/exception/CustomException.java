package meetUpBackend.groad.common.exception;

public class CustomException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private final ErrorCode errorCode;

	public CustomException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public CustomException(ErrorCode errorCode){
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
	public ErrorCode getErrorCode(ErrorCode nvalidParameter) {
		return errorCode;
	}
}
