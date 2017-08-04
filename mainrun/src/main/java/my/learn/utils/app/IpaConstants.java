package my.learn.utils.app;

import java.util.Arrays;
import java.util.List;

/**
 * IPA解析配置
 * 
 * @author lin
 * @date 2017年7月27日 上午10:08:56
 */
public class IpaConstants {
	/**
	 * 需要读取的文件列表
	 */
	protected static final List<String> FILESS = Arrays.asList("Payload/mobile_portal.app/Info.plist",
			"Payload/mobile_portal.app/forceUpgrade.plist");
	/**
	 * APP名称
	 */
	public static final String NAME = "CFBundleDisplayName";
	/**
	 * 强制更新
	 */
	public static final String FORCE_UPGRADE = "forceUpgrade";
	/**
	 * 版本号
	 */
	public static final String VERSION_CODE = "CFBundleShortVersionString";
	/**
	 * 版本名称
	 */
	public static final String VERSION_NAME = "CFBundleVersion";
	/**
	 * 包
	 */
	public static final String PACKAGE = "CFBundleIdentifier";
	/**
	 * 最小版本要求
	 */
	public static final String MIN_OS_VERSION = "MinimumOSVersion";
}
