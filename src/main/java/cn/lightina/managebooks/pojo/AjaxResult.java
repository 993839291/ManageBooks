package cn.lightina.managebooks.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @description 服务器响应结果
 */
@Data
public class AjaxResult implements Serializable {

	/**
	 * 响应编码
	 */
	private int code;

	/**
	 * 响应信息
	 */
	private String message;

	/**
	 * 响应数据
	 */
	private Object data;

	public AjaxResult() {
	}

	public AjaxResult(int code, String msg, Object data) {
		this.code = code;
		this.message = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 成功默认返回
	 * 
	 * @param
	 * @return com.yunke.common.utils.AjaxResult
	 * @author ljl
	 **/
	public static AjaxResult success() {
		return new AjaxResult(ResponseCode.SUCCESS, "成功", null);
	}

	/**
	 * 自定义返回消息
	 * 
	 * @param message
	 *            返回消息
	 * @return com.yunke.common.utils.AjaxResult
	 * @author ljl
	 **/
	public static AjaxResult success(String message) {
		return new AjaxResult(ResponseCode.SUCCESS, message, null);
	}

	/**
	 * 成功-有返回数据
	 * 
	 * @param data
	 *            成功返回数据
	 * @return com.yunke.common.utils.AjaxResult
	 * @author ljl
	 **/
	public static AjaxResult success(Object data) {
		return new AjaxResult(ResponseCode.SUCCESS, "成功", data);
	}

	/**
	 * 成功-有返回数据
	 *
	 * @param data
	 *            成功返回数据
	 * @return com.yunke.common.utils.AjaxResult
	 * @author ljl
	 **/
	public static AjaxResult success(String message,Object data) {
		return new AjaxResult(ResponseCode.SUCCESS, message, data);
	}

	/**
	 * 失败默认返回
	 * 
	 * @param message
	 *            返回消息
	 * @return com.yunke.common.utils.AjaxResult
	 * @author ljl
	 **/
	public static AjaxResult error(String message) {
		return new AjaxResult(ResponseCode.ERROR, message, null);
	}

	/**
	 * 失败返回
	 * 
	 * @param message
	 *            返回消息
	 * @return com.yunke.common.utils.AjaxResult
	 * @author lys
	 **/
	public static AjaxResult fail(int code, String message) {
		return new AjaxResult(code, message, null);
	}

	/**
	 * 失败返回
	 *
	 * @param message
	 *            返回消息
	 * @return com.yunke.common.utils.AjaxResult
	 * @author lys
	 **/
	public static AjaxResult fail(int code, String message, Object data) {
		return new AjaxResult(code, message, data);
	}
}
