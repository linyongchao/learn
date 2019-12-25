package my.learn.utils;

public class SnowflakeTest {
    public static void main(String[] args) {
        int num = 100;
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        for (int i = 0; i < num; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }
        System.out.println("---------");
        for (int i = 0; i < num; i++) {
            long id = IdCenterUtil.getInstance().nextId();
            System.out.println(id);
        }
    }
}
