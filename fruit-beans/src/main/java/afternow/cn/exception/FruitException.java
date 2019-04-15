package afternow.cn.exception;

import lombok.Data;

/**
 * @author libo
 */
@Data
public class FruitException extends RuntimeException {
	private String code;

	private String message;
	
	public FruitException(String code) {
		this.code = code;
	}

	public FruitException(String code, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
		this.message = message;
	}

	public FruitException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
}
