package my.learn.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES 加密、解密
 * 
 * @author lin
 * @date 2018年5月23日 上午11:00:35
 */
public final class AESUtils {

	private static final String AES = "AES";
	private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
	/**
	 * 密钥长度
	 */
	private static final int LENGTH = 128;

	/**
	 * 生成密钥
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @author lin
	 * @date 2018年5月23日 上午11:07:04
	 */
	public static byte[] getKeyBytes() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
		keyGenerator.init(LENGTH);
		return keyGenerator.generateKey().getEncoded();
	}

	/**
	 * 生成密钥
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @author lin
	 * @date 2018年5月23日 上午11:07:04
	 */
	public static String getKey() throws NoSuchAlgorithmException {
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
	 * @date 2018年5月23日 上午11:01:38
	 */
	public static byte[] encrypt(byte[] contextBytes, byte[] keyBytes) {
		try {
			SecretKey secretKey = new SecretKeySpec(keyBytes, AES);
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
			return cipher.doFinal(contextBytes);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
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
	 * @date 2018年5月23日 上午11:06:36
	 */
	public static String encrypt(String context, String key) {
		try {
			byte[] resultBytes = encrypt(context.getBytes("utf-8"), Base64Utils.decode(key));
			return Base64Utils.encode(resultBytes);
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
	 * @date 2018年5月23日 上午10:58:24
	 */
	public static byte[] decrypt(byte[] contextBytes, byte[] keyBytes) {
		try {
			SecretKey secretKey = new SecretKeySpec(keyBytes, AES);
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(new byte[cipher.getBlockSize()]));
			return cipher.doFinal(contextBytes);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
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
	 * @date 2018年5月23日 上午10:58:06
	 */
	public static String decrypt(String context, String key) {
		// 防止秘钥中有空格
		key = key.replace(" ", "+");
		byte[] keyBytes = Base64Utils.decode(key);
		byte[] contextBytes = Base64Utils.decode(context);
		byte[] result = decrypt(contextBytes, keyBytes);
		try {
			return new String(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		String context = "mytest";
		System.out.println("加密内容：" + context);

		byte[] keyBytes = getKeyBytes();
		String key = Base64Utils.encode(keyBytes);
		System.out.println("加密密钥：" + key);

		byte[] encryBytes = encrypt(context.getBytes("utf-8"), Base64Utils.decode(key));
		String encryStr = Base64Utils.encode(encryBytes);
		System.out.println("byte 加密后：" + encryStr);
		String encry = encrypt(context, key);
		System.out.println("str 加密后：" + encry);

		byte[] decryBytes = decrypt(encryBytes, Base64Utils.decode(key));
		String decryStr = new String(decryBytes, "utf-8");
		System.out.println("byte 解密后：" + decryStr);
		String decry = decrypt(encry, key);
		System.out.println("str 解密后：" + decry);
	}

}
