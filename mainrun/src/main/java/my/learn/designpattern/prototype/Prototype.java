package my.learn.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 浅复制
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Prototype) super.clone();
	}

	/**
	 * @Description 深复制
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @author lin
	 * @date 2017年8月15日 下午5:37:16
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		// 写入当前对象的二进制流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		// 读出二进制流产生的新对象
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

}
