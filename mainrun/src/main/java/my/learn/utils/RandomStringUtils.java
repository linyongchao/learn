package my.learn.utils;

import java.util.Random;

/**
 * 生成随机字符串
 * 
 * @author lin
 * @date 2018年5月23日 下午3:24:24
 */
public class RandomStringUtils {

	/**
	 * 生成长度为 length 的随机字符串
	 * 
	 * @param length
	 *            随机字符串的长度
	 * @return
	 * @author lin
	 * @date 2018年5月23日 下午3:16:31
	 */
	public static String methodA(int length) {
		// 定义一个字符串（0-9，A-Z，a-z)
		String sequence = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(sequence.length());
			sb.append(sequence.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成长度为 length 的随机字符串
	 * 
	 * @param length
	 *            随机字符串的长度
	 * @return
	 * @author lin
	 * @date 2018年5月23日 下午3:18:20
	 */
	public static String methodB(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			// 产生 0，1，2 三个随机数，即 A-Z，a-z，0-9 三种可能
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
			case 0:
				// 产生 A-Z 的ASCII码
				result = Math.round(Math.random() * 25 + 65);
				// 将ASCII码转换成字符
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				// 产生a-z的ASCII码
				result = Math.round(Math.random() * 25 + 97);
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				// 产生0-9的数字
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(RandomStringUtils.methodA(10));
		System.out.println(RandomStringUtils.methodB(10));
	}
}
