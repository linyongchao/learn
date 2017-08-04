package my.learn.utils.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListFormatException;
import com.dd.plist.PropertyListParser;

/**
 * Ipa解析工具类
 * 
 * @author lin
 * @date 2017年7月26日 下午6:53:22
 */
public class IpaParseUtil {

	/**
	 * 解析IPA并屏蔽异常
	 * 
	 * @param ipaPath
	 * @return
	 * @author lin
	 * @date 2017年7月27日 上午10:01:33
	 */
	public static Map<String, String> readIPAQuietly(String ipaPath) {
		Map<String, String> readIPA = null;
		try {
			readIPA = readIPA(ipaPath);
		} catch (IOException | PropertyListFormatException | ParseException | ParserConfigurationException
				| SAXException e) {
			e.printStackTrace();
		}
		return readIPA;
	}

	/**
	 * 解析IPA
	 * 
	 * @param ipaPath
	 * @return
	 * @throws IOException
	 * @throws PropertyListFormatException
	 * @throws ParseException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @author lin
	 * @date 2017年7月27日 上午10:01:06
	 */
	private static Map<String, String> readIPA(String ipaPath) throws IOException, PropertyListFormatException,
			ParseException, ParserConfigurationException, SAXException {
		Map<String, String> map = new HashMap<String, String>();
		File file = new File(ipaPath);
		InputStream is = new FileInputStream(file);
		ZipInputStream zipIns = new ZipInputStream(is);
		ZipEntry ze;
		InputStream infoIs = null;
		int count = 0;
		while ((ze = zipIns.getNextEntry()) != null) {
			if (!ze.isDirectory()) {
				String name = ze.getName();
				if (IpaConstants.FILESS.contains(name)) {
					count++;
					ByteArrayOutputStream _copy = new ByteArrayOutputStream();
					int chunk = 0;
					byte[] data = new byte[1024];
					while (-1 != (chunk = zipIns.read(data))) {
						_copy.write(data, 0, chunk);
					}
					infoIs = new ByteArrayInputStream(_copy.toByteArray());
					NSDictionary rootDict = (NSDictionary) PropertyListParser.parse(infoIs);
					for (String keyName : rootDict.allKeys()) {
						map.put(keyName, rootDict.get(keyName).toString());
					}
					infoIs.close();
					if (count == IpaConstants.FILESS.size()) {
						break;
					}
				}
			}
		}
		is.close();
		zipIns.close();
		return map;
	}
}
