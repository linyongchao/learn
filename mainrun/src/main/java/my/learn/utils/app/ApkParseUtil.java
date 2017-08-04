package my.learn.utils.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apkinfo.api.util.AXmlResourceParser;
import org.apkinfo.api.util.TypedValue;
import org.apkinfo.api.util.XmlPullParser;
import org.apkinfo.api.util.XmlPullParserException;

/**
 * Apk解析工具类
 * 
 * @author lin
 * @date 2017年7月24日 上午10:57:25
 */
public class ApkParseUtil {
	private static final float RADIX_MULTS[] = { 0.00390625F, 3.051758E-005F, 1.192093E-007F, 4.656613E-010F };
	private static final String DIMENSION_UNITS[] = { "px", "dip", "sp", "pt", "in", "mm", "", "" };
	private static final String FRACTION_UNITS[] = { "%", "%p", "", "", "", "", "", "" };

	/**
	 * 获取APK配置文件中的某个属性值（先读取后取值）
	 * 
	 * @param apkPath
	 * @param key
	 * @return
	 * @author lin
	 * @date 2017年7月24日 上午11:16:49
	 */
	public static String getAttribute(String apkPath, String key) {
		List<Map<String, String>> readAPK = readAPKQuietly(apkPath);
		return getAttribute(readAPK, key);
	}

	/**
	 * 获取APK配置文件中的某个属性值（不读取只取值）
	 * 
	 * @param readAPK
	 * @param key
	 * @return
	 * @author lin
	 * @date 2017年7月25日 下午2:45:52
	 */
	public static String getAttribute(List<Map<String, String>> readAPK, String key) {
		if (readAPK == null || readAPK.size() == 0) {
			return null;
		}
		String value = null;
		for (Map<String, String> map : readAPK) {
			for (Entry<String, String> m : map.entrySet()) {
				if (key.equals(m.getKey())) {
					value = m.getValue();
					break;
				}
			}
		}
		return value;
	}

	/**
	 * 解析APK并屏蔽其异常
	 * 
	 * @param apkPath
	 * @return
	 * @author lin
	 * @date 2017年7月24日 上午11:16:03
	 */
	public static List<Map<String, String>> readAPKQuietly(String apkPath) {
		List<Map<String, String>> readAPK = null;
		try {
			readAPK = readAPK(apkPath);
		} catch (IOException | XmlPullParserException e) {
			e.printStackTrace();
		}
		return readAPK;
	}

	/**
	 * 读取APK文件，获取其中的AndroidManifest.xml
	 * 
	 * @param apkPath
	 * @return
	 * @throws IOException
	 * @throws XmlPullParserException
	 * @author lin
	 * @date 2017年7月24日 上午10:52:19
	 */
	private static List<Map<String, String>> readAPK(String apkPath) throws IOException, XmlPullParserException {
		ZipFile zipFile = new ZipFile(apkPath);
		Enumeration<?> enumeration = zipFile.entries();
		ZipEntry zipEntry = null;
		List<Map<String, String>> list = null;
		while (enumeration.hasMoreElements()) {
			zipEntry = (ZipEntry) enumeration.nextElement();
			if (!zipEntry.isDirectory() && ApkConstants.MANIFEST.equals(zipEntry.getName().toLowerCase())) {
				InputStream inputStream = zipFile.getInputStream(zipEntry);
				list = parse(inputStream);
				break;
			}
		}
		zipFile.close();
		return list;
	}

	/**
	 * 解析 AndroidManifest.xml
	 * 
	 * @param inputStream
	 * @return
	 * @throws XmlPullParserException
	 * @throws IOException
	 * @author lin
	 * @date 2017年7月24日 上午10:48:51
	 */
	private static List<Map<String, String>> parse(InputStream inputStream) throws XmlPullParserException, IOException {
		AXmlResourceParser parser = new AXmlResourceParser();
		parser.open(inputStream);
		List<Map<String, String>> list = new ArrayList<>();
		while (true) {
			int type = parser.next();
			if (type == XmlPullParser.END_DOCUMENT) {
				break;
			}
			switch (type) {
			case XmlPullParser.START_TAG:
				if (ApkConstants.ELEMENTS.contains(parser.getName())) {
					String key = null;
					Map<String, String> map = null;
					int count = parser.getAttributeCount();
					if (count == 2) {// 属性为两行时，第一行为key，第二行为value
						for (int i = 0; i != count; ++i) {
							String value = getAttributeValue(parser, i);
							if (key != null) {
								map = new HashMap<>();
								map.put(key, value);
								if (i == count - 1) {
									key = null;
									list.add(map);
								}
							} else if (ApkConstants.ATTRIBUTES.contains(value)) {
								key = value;
							}
						}
					} else {// 属性不为两行时，=前为key，=后为value
						for (int i = 0; i != count; ++i) {
							map = new HashMap<>();
							map.put(parser.getAttributeName(i), getAttributeValue(parser, i));
							list.add(map);
						}
					}
				}
				break;
			case XmlPullParser.START_DOCUMENT:
				break;
			case XmlPullParser.END_TAG:
				break;
			case XmlPullParser.TEXT:
				continue;
			default:
				break;
			}
		}
		return list;
	}

	private static String getAttributeValue(AXmlResourceParser parser, int index) {
		int type = parser.getAttributeValueType(index);
		int data = parser.getAttributeValueData(index);
		if (type == TypedValue.TYPE_ATTRIBUTE) {
			return String.format("?%s%08X", getPackage(data), data);
		}
		if (type == TypedValue.TYPE_INT_BOOLEAN) {
			return data != 0 ? "true" : "false";
		}
		if (type == TypedValue.TYPE_DIMENSION) {
			return Float.toString(complexToFloat(data)) + DIMENSION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
		}
		if (type == TypedValue.TYPE_FLOAT) {
			return String.valueOf(Float.intBitsToFloat(data));
		}
		if (type == TypedValue.TYPE_FRACTION) {
			return Float.toString(complexToFloat(data)) + FRACTION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
		}
		if (type == TypedValue.TYPE_INT_HEX) {
			return String.format("0x%08X", data);
		}
		if (type == TypedValue.TYPE_REFERENCE) {
			return String.format("@%s%08X", getPackage(data), data);
		}
		if (type == TypedValue.TYPE_STRING) {
			return parser.getAttributeValue(index);
		}
		if (type >= TypedValue.TYPE_FIRST_COLOR_INT && type <= TypedValue.TYPE_LAST_COLOR_INT) {
			return String.format("#%08X", data);
		}
		if (type >= TypedValue.TYPE_FIRST_INT && type <= TypedValue.TYPE_LAST_INT) {
			return String.valueOf(data);
		}
		return String.format("<0x%X, type 0x%02X>", data, type);
	}

	private static String getPackage(int id) {
		if (id >>> 24 == 1) {
			return "android:";
		}
		return "";
	}

	private static float complexToFloat(int complex) {
		return (float) (complex & 0xFFFFFF00) * RADIX_MULTS[(complex >> 4) & 3];
	}

}
