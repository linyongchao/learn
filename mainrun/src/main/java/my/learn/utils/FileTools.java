package my.learn.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @Description:文件操作工具类
 * @author lin
 * @date 2013-7-29 下午7:36:51
 */
public class FileTools {

	/**
	 * 向文件内追加内容
	 * 
	 * @param filePath
	 * @param writeContext
	 */
	public static void appendWrite(String filePath, String writeContext) {
		if (!new File(filePath).exists()) {
			createFile(filePath);
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath, true);
			fw.write(writeContext);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 创建文件
	 * 
	 * @param path
	 *            ： 路径格式若为：/home/down/test.txt，
	 *            若路径不存在，则生成home/down文件夹后生成test.txt文件
	 */
	public static void createFile(String path) {
		File file = new File(path);
		File parent = file.getParentFile();
		if (parent != null && !parent.exists()) {
			parent.mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("文件创建异常：" + e);
		}
	}

	/**
	 * 检验该路径是否存在：适用于文件和文件夹
	 * 
	 * @param path
	 * 			@return： true，存在；false，不存在
	 */
	public static boolean checkPath(String path) {
		return new File(path).exists();
	}

	/**
	 * 获取文件大小
	 * 
	 * @param pathStr
	 * @return
	 */
	public static Long getFileSize(String pathStr) {
		Path path = Paths.get(pathStr);
		BasicFileAttributes attributes;
		try {
			attributes = Files.readAttributes(path, BasicFileAttributes.class);
			return attributes.size();
		} catch (IOException e) {
			System.out.println("读取不到文件" + pathStr);
			e.printStackTrace();
		}
		return 0L;
	}

}
