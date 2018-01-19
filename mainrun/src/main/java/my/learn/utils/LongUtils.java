package my.learn.utils;

public class LongUtils {

	public static void main(String[] args) {
		String a = "92233720368547758071";
		String b = "999999999999999999";
		String c = "9223372036854775807";

		System.out.println(isLong(a));
		System.out.println(isLong(b));
		System.out.println(isLong(c));
	}

	/**
	 * 判断一个非负字符串数字是否是是long类型
	 * 
	 * @param l
	 * @return
	 * @author lin
	 * @date 2018年1月19日 上午10:56:19
	 */
	public static boolean isLong(String l) {
		int maxLength = String.valueOf(Long.MAX_VALUE).length();
		if (l.length() > maxLength) {
			return false;
		}
		if (l.length() == maxLength) {
			return l.compareTo(String.valueOf(Long.MAX_VALUE)) <= 0;
		}
		return true;
	}

}
