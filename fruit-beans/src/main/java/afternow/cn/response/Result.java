package afternow.cn.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * HTTP请求返回对象
 * 
 * @author been
 *
 * @param <T>
 */
@Data
@ApiModel
public class Result<T> {

	@ApiModelProperty(value = "业务code")
	private String code ;

	@ApiModelProperty(value = "错误信息")
	private String message;

	@ApiModelProperty(value = "1 ：正常 -1： 异常")
	private Integer status = 1;

	@ApiModelProperty(value = "请求路径")
	private String path;
	/**
	 * 具体数据
	 */
	@ApiModelProperty(value = "返回数据")
	private T data;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(String code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

	public Result(T data) {
		super();
		this.data = data;
	}

	public Result(String code, String message, Integer status, T data) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
		this.data = data;
	}

}