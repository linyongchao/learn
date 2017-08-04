package my.learn.utils.app;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * APP解析工具类
 * 
 * @author lin
 * @date 2017年7月27日 上午9:59:11
 */
public class AppParseUtil {

	/**
	 * Android应用后缀
	 */
	private static final String APK = "apk";
	/**
	 * iOS应用后缀
	 */
	private static final String IPA = "ipa";
	/**
	 * Android平台数据库标识
	 */
	private static final String PLAT_ANDROID = "1";
	/**
	 * iOS平台数据库标识
	 */
	private static final String PLAT_IOS = "2";
	/**
	 * 和APP开发者约定的强制升级
	 */
	private static final String APP_TRUE = "true";
	/**
	 * 和APP开发者约定的非强制升级
	 */
	private static final String APP_FALSE = "false";
	/**
	 * 数据库强制升级
	 */
	private static final Integer DB_TRUE = 1;
	/**
	 * 数据库非强制升级
	 */
	private static final Integer DB_FALSE = 2;

	/**
	 * 解析APP
	 * 
	 * @param path
	 * @return
	 * @author lin
	 * @date 2017年7月27日 上午9:59:22
	 */
	public static AppParse parse(String path) {
		if (path == null) {
			return null;
		}
		File app = new File(path);
		if (!app.isFile()) {
			return null;
		}
		AppParse appParse = null;
		String forceUpgrade = null;
		if (path.toLowerCase().endsWith(APK)) {
			appParse = new AppParse();
			List<Map<String, String>> readAPK = ApkParseUtil.readAPKQuietly(path);
			forceUpgrade = ApkParseUtil.getAttribute(readAPK, ApkConstants.FORCE_UPGRADE);// 是否强制升级
			String[] split = path.split("/");
			appParse.setName(split[split.length - 1]);
			appParse.setPkg(ApkParseUtil.getAttribute(readAPK, ApkConstants.PACKAGE));
			appParse.setPlat(PLAT_ANDROID);
			appParse.setVersionCode(ApkParseUtil.getAttribute(readAPK, ApkConstants.VERSION_CODE));
			appParse.setVersionName(ApkParseUtil.getAttribute(readAPK, ApkConstants.VERSION_NAME));
		}
		if (path.toLowerCase().endsWith(IPA)) {
			appParse = new AppParse();
			Map<String, String> readIPA = IpaParseUtil.readIPAQuietly(path);
			forceUpgrade = readIPA.get(IpaConstants.FORCE_UPGRADE);
			appParse.setName(readIPA.get(IpaConstants.NAME));
			appParse.setPkg(readIPA.get(IpaConstants.PACKAGE));
			appParse.setPlat(PLAT_IOS);
			appParse.setMinVersion(readIPA.get(IpaConstants.MIN_OS_VERSION));
			appParse.setVersionCode(readIPA.get(IpaConstants.VERSION_CODE));
			appParse.setVersionName(readIPA.get(IpaConstants.VERSION_NAME));
		}

		int force = 0;
		if (forceUpgrade != null) {
			if (forceUpgrade.equals(APP_TRUE)) {
				force = DB_TRUE;
			} else if (forceUpgrade.equals(APP_FALSE)) {
				force = DB_FALSE;
			}
			appParse.setForceUpgrade(force);
			appParse.setPath(path);
			appParse.setSize(app.length());
		}
		return appParse;
	}
}
