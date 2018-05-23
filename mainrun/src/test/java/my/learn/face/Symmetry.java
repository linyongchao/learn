package my.learn.face;

/**
 * 判断一个字符串是否对称
 * 
 * @author lin
 * @date 2018年3月22日 上午11:06:15
 */
public class Symmetry {

	public static void main(String[] args) {
		String str = "abcaaa";
		System.out.println(isSymmetryBySplit(str));
		System.out.println(isSymmetryByChar(str));
		System.out.println(isSymmetryByCharAt(str));
		System.out.println(isSymmetryByReverse(str));
		System.out.println("------");
		String str1 = "abcba";
		System.out.println(isSymmetryBySplit(str1));
		System.out.println(isSymmetryByChar(str1));
		System.out.println(isSymmetryByCharAt(str1));
		System.out.println(isSymmetryByReverse(str1));
		System.out.println("------");
		String str2 = "abccba";
		System.out.println(isSymmetryBySplit(str2));
		System.out.println(isSymmetryByChar(str2));
		System.out.println(isSymmetryByCharAt(str2));
		System.out.println(isSymmetryByReverse(str2));
		System.out.println("------");
	}

	/**
	 * 利用split拆分
	 * 
	 * @param str
	 * @return
	 * @author lin
	 * @date 2018年3月22日 上午11:27:34
	 */
	public static boolean isSymmetryBySplit(String str) {
		String[] split = str.split("");
		boolean result = true;
		for (int i = 0, j = split.length - 1; i < j; i++, j--) {
			if (!split[i].equals(split[j])) {
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * 利用toCharArray转换成char数组
	 * 
	 * @param str
	 * @return
	 * @author lin
	 * @date 2018年3月22日 上午11:27:49
	 */
	public static boolean isSymmetryByChar(String str) {
		char[] split = str.toCharArray();
		boolean result = true;
		for (int i = 0, j = split.length - 1; i < j; i++, j--) {
			if (split[i] != split[j]) {
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * 利用charAt取指定位置的字符
	 * 
	 * @param str
	 * @return
	 * @author lin
	 * @date 2018年3月22日 上午11:28:09
	 */
	public static boolean isSymmetryByCharAt(String str) {
		boolean result = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * 利用StringBuffer/StringBuilder的reverse方法
	 * 
	 * @param str
	 * @return
	 * @author lin
	 * @date 2018年3月22日 上午11:29:09
	 */
	public static boolean isSymmetryByReverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		String tmp = sb.reverse().toString();
		return str.equals(tmp);
	}

}
