package my.learn.utils.app;

import java.util.Arrays;
import java.util.List;

/**
 * APK解析配置
 * 
 * @author lin
 * @date 2017年7月27日 上午10:04:03
 */
public class ApkConstants {
	/**
	 * 需要读取的文件名称
	 */
	protected static final String MANIFEST = "androidmanifest.xml";
	/**
	 * 需要读取的元素列表
	 */
	protected static final List<String> ELEMENTS = Arrays.asList("meta-data", "manifest");
	/**
	 * 强制更新
	 */
	public static final String FORCE_UPGRADE = "com.portal.forceUpgrade";
	/**
	 * 版本号
	 */
	public static final String VERSION_CODE = "versionCode";
	/**
	 * 版本名称
	 */
	public static final String VERSION_NAME = "versionName";
	/**
	 * 包
	 */
	public static final String PACKAGE = "package";
	/**
	 * 需要读取的属性列表（只有第一行为key，第二行为value时才需要配置这里）
	 */
	protected static final List<String> ATTRIBUTES = Arrays.asList(FORCE_UPGRADE);
}
