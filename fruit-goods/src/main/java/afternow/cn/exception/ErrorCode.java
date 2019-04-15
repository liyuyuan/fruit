package afternow.cn.exception;

/**
 * 
 * @author liyuyuan_vendor
 * 	错误码
 */
public interface ErrorCode {
	FruitException FACE_QUALITY_LOW = new FruitException("414001","人脸质量分数低");
	FruitException FACE_MORE_THAN_ONE = new FruitException("414002","图片存在多张人脸");
	FruitException FACE_NOT_FOUND = new FruitException("414003","检测不到人脸");
	FruitException FACE_BATCH_DETECT_AND_EXTRACT = new FruitException("514004","提取特征失败");
	FruitException BASE64_TOFILE_ERROR = new FruitException("514005","base64字符串异常或地址异常");
	FruitException FILE_SIZE_MORE_THAN_MAX = new FruitException("414006","图片大小不能超过16M");
	FruitException FILE_FORMAT_NOT_SUPPORTED = new FruitException("414007","图片格式不支持");
	FruitException NETWORK_PICTURE_NOT_EXIST = new FruitException("414008","网络图片不存在");
	
}
