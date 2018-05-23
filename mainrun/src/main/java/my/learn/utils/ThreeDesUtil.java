package my.learn.utils;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 3Des 加密、解密
 * 
 * @author lin
 * @date 2018年5月23日 上午11:18:53
 */
public class ThreeDesUtil {

	private static final String ALGORITHM = "desede";
	private static final String TRANSFORMATION = "desede/CBC/PKCS5Padding";
	/**
	 * 秘钥长度
	 */
	private static final int KEY_LENGTH = 24;
	/**
	 * 偏移量
	 */
	private static final int IV_LENGTH = 8;

	/**
	 * 生成密钥
	 * 
	 * @return
	 * @author lin
	 * @date 2018年5月23日 上午11:24:21
	 */
	public static byte[] getKeyBytes() {
		SecureRandom sr = new SecureRandom();
		byte[] output = new byte[KEY_LENGTH];
		sr.nextBytes(output);
		return output;
	}

	/**
	 * 生成密钥
	 * 
	 * @return
	 * @author lin
	 * @date 2018年5月23日 上午11:24:33
	 */
	public static String getKey() {
		return Base64Utils.encode(getKeyBytes());
	}

	/**
	 * 加密
	 * 
	 * @param contextBytes
	 *            加密内容
	 * @param keyBytes
	 *            密钥
	 * @return
	 * @author lin
	 * @date 2018年5月23日 上午11:26:57
	 */
	public static byte[] encrypt(byte[] contextBytes, byte[] keyBytes) {
		Key deskey = null;
		try {
			DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(ALGORITHM);
			deskey = keyfactory.generateSecret(spec);

			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			byte[] iv = new byte[IV_LENGTH];
			System.arraycopy(keyBytes, 0, iv, 0, IV_LENGTH);
			IvParameterSpec ips = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
			return cipher.doFinal(contextBytes);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return null;
		}
	}

	/**
	 * 加密
	 * 
	 * @param context
	 *            加密内容
	 * @param key
	 *            密钥
	 * @return
	 * @author lin
	 * @date 2018年5月23日 上午11:31:32
	 */
	public static String encrypt(String context, String key) {
		try {
			byte[] encode = encrypt(context.getBytes("utf-8"), Base64Utils.decode(key));
			return Base64Utils.encode(encode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解密
	 * 
	 * @param contextBytes
	 *            解密内容
	 * @param keyBytes
	 *            密钥
	 * @return
	 * @author lin
	 * @date 2018年5月23日 上午11:33:39
	 */
	public static byte[] decrypt(byte[] contextBytes, byte[] keyBytes) {
		Key deskey = null;
		try {
			DESedeKeySpec spec = new DESedeKeySpec(keyBytes);
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance(ALGORITHM);
			deskey = keyfactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			byte[] iv = new byte[IV_LENGTH];
			System.arraycopy(keyBytes, 0, iv, 0, IV_LENGTH);
			IvParameterSpec ips = new IvParameterSpec(iv);
			cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
			return cipher.doFinal(contextBytes);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return null;
		}
	}

	/**
	 * 解密
	 * 
	 * @param context
	 *            解密内容
	 * @param key
	 *            密钥
	 * @return
	 * @author lin
	 * @date 2018年5月23日 上午11:40:08
	 */
	public static String decrypt(String context, String key) {
		byte[] result = decrypt(Base64Utils.decode(context), Base64Utils.decode(key));
		try {
			return new String(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String context = "mytest";
		System.out.println("加密内容：" + context);

		byte[] keyBytes = getKeyBytes();
		String key = Base64Utils.encode(keyBytes);
		System.out.println("加密密钥：" + key);

		byte[] encryBytes = encrypt(context.getBytes("utf-8"), keyBytes);
		String encryStr = Base64Utils.encode(encryBytes);
		System.out.println("byte 加密后：" + encryStr);
		String encry = encrypt(context, key);
		System.out.println("str 加密后：" + encry);

		byte[] decryBytes = decrypt(encryBytes, keyBytes);
		String decryStr = new String(decryBytes, "utf-8");
		System.out.println("byte 解密后：" + decryStr);
		String decry = decrypt(encry, key);
		System.out.println("str 解密后：" + decry);
	}
}
