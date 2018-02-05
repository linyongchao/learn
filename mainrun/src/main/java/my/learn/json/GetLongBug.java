package my.learn.json;

import net.sf.json.JSONObject;

/**
 * JSONObject对象的getLong方法有bug，具体表现如例子
 * 
 * @author lin
 * @date 2018年2月5日 下午3:26:24
 */
public class GetLongBug {
	public static void main(String[] args) {
		String oldAttr = "{\"App.ID\":\"1111731461652485603\"}";
		JSONObject json = JSONObject.fromObject(oldAttr);
		// getLong方法输出结果为：1111731461652485632
		Long appId = json.getLong("App.ID");
		System.out.println(appId);
		// getString再转long输出结果为：1111731461652485603
		String stringId = json.getString("App.ID");
		System.out.println(Long.valueOf(stringId));
	}
}
