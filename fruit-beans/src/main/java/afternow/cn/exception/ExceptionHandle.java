package afternow.cn.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import afternow.cn.constants.FruitServerConstants;
import afternow.cn.response.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author liyuyuan_vendor
 *
 */
@SuppressWarnings("rawtypes")
@Slf4j
@ControllerAdvice
public class ExceptionHandle {
	@Autowired
	private HttpServletRequest request;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Result> handleException(Exception e) {
		FruitException exception;
		HttpStatus httpStatus = null;
		if (e instanceof FruitException) {
			exception = (FruitException) e;
			if (exception.getCode().contains(FruitServerConstants.SERVER_ERROR)) {
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} else {
			log.info("[系统异常]{}", e);
			return new ResponseEntity<>(error("-1", "系统异常，请稍后再试"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(error(exception.getCode(), exception.getMessage()), httpStatus);
	}

	public Result error(String code, String msg) {
		Result result = new Result();
		result.setCode(code);
		result.setMessage(msg);
		result.setStatus(-1);
		result.setPath(request.getServletPath());
		return result;
	}

}
