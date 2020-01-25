package my.learn.pattern.clone;


import java.io.*;

/**
 * 深克隆对象<br/>
 * 深克隆需要实现 Serializable 接口<br/>
 *
 * @author lin
 * @return
 * @date 2019/11/26 16:08
 **/
public class PersonDeep implements Serializable {
    private String name;
    private int age;

    public PersonDeep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try (ByteArrayOutputStream bo = new ByteArrayOutputStream();
             ObjectOutputStream oo = new ObjectOutputStream(bo)) {
            //序列化
            oo.writeObject(this);
            try (ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
                 ObjectInputStream oi = new ObjectInputStream(bi)) {
                //反序列化
                return oi.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
