package my.learn.utils.app;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class AppParseTest {
	private static String apkPath = null;
	private static String ipaPath = null;

	@BeforeClass
	public static void init() {
		apkPath = "/Users/lin/zzy/apk/portal-main-debug1.0.2.apk";
		ipaPath = "/Users/lin/zzy/apk/mobile_portal_2.1.ipa";
	}

	/**
	 * @Description 获取APK多条属性
	 * @author lin
	 * @date 2017年8月4日 上午11:42:45
	 */
	@Test
	public void getApkAttributes() {
		List<Map<String, String>> readAPK = ApkParseUtil.readAPKQuietly(apkPath);
		String versionCode = ApkParseUtil.getAttribute(readAPK, ApkConstants.VERSION_CODE);
		String versionName = ApkParseUtil.getAttribute(readAPK, ApkConstants.VERSION_NAME);
		System.out.println(versionCode);
		System.out.println(versionName);
		System.out.println("---get Apk Attributes end---");
		System.out.println();
	}

	/**
	 * @Description 获取APK一条属性
	 * @author lin
	 * @date 2017年8月4日 上午11:42:15
	 */
	@Test
	public void getApkAttribute() {
		String pkg = ApkParseUtil.getAttribute(apkPath, ApkConstants.PACKAGE);
		System.out.println(pkg);
		System.out.println("---get Apk Attribute end---");
		System.out.println();
	}

	/**
	 * @Description 获取IPA属性
	 * @author lin
	 * @date 2017年8月4日 上午11:55:23
	 */
	@Test
	public void getIpaAttribute() {
		Map<String, String> readIPA = IpaParseUtil.readIPAQuietly(ipaPath);
		System.out.println(readIPA.get(IpaConstants.VERSION_CODE));
		System.out.println(readIPA.get(IpaConstants.VERSION_NAME));
		System.out.println(readIPA.get(IpaConstants.PACKAGE));
		System.out.println("---get Ipa Attribute end---");
		System.out.println();
	}

	/**
	 * @Description 解析APP包
	 * @author lin
	 * @date 2017年8月4日 下午12:19:04
	 */
	@Test
	public void parseApp() {
		AppParse ipa = AppParseUtil.parse(ipaPath);
		System.out.println(ipa.toString());
		AppParse apk = AppParseUtil.parse(apkPath);
		System.out.println(apk.toString());
		System.out.println("---parse App end---");
		System.out.println();
	}

}
