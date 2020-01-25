package my.learn.utils;

/**
 * 静态id生成器
 *
 * @author
 */
public class IdCenterUtil {
    private volatile static IdCenterUtil instance = null;

    private IdCenterUtil() {
    }

    public static IdCenterUtil getInstance() {
        if (instance == null) {
            synchronized (IdCenterUtil.class) {
                if (instance == null) {
                    instance = new IdCenterUtil();
                    instance.initParam();
                }
            }
        }
        return instance;
    }

    /**
     * 节点 ID 默认取1
     */
    private long workerId = 1;
    /**
     * 数据中心的ID 默认取1
     */
    private long datacenterId = 1;
    /**
     * 序列id 默认取1
     */
    private long sequence = 1;
    /**
     * 起始纪元
     */
    private long idepoch = 1546272000000L;
    /**
     * 机器标识位数
     */
    private final long workerIdBits = 5L;
    /**
     * 数据中心标识位数
     */
    private final long datacenterIdBits = 5L;
    /**
     * 机器ID最大值
     */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    /**
     * 数据中心ID最大值
     */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    /**
     * 毫秒内自增位
     */
    private final long sequenceBits = 12L;
    /**
     * 机器ID偏左移12位
     */
    private final long workerIdShift = sequenceBits;
    /**
     * 数据中心ID左移17位
     */
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    /**
     * 时间毫秒左移22位
     */
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;

    private void initParam() {
        if (workerId < 0 || workerId > maxWorkerId) {
            throw new IllegalArgumentException("workerId is illegal: " + workerId);
        }
        if (datacenterId < 0 || datacenterId > maxDatacenterId) {
            throw new IllegalArgumentException("datacenterId is illegal: " + workerId);
        }
        workerId = getIpFlag(4);
        if (workerId > maxDatacenterId) {
            workerId = workerId % maxDatacenterId;
        }

        datacenterId = getIpFlag(3);
        if (datacenterId > maxWorkerId) {
            datacenterId = datacenterId % maxWorkerId;
        }
    }

    /**
     * 获取ip第几位 从1开始
     *
     * @param flag
     * @return
     */
    private Long getIpFlag(int flag) {
        String ip = IpUtil.getLocalIp();
        String[] ips = ip.split("[.]");
        return Long.valueOf(ips[flag - 1]);
    }

    /**
     * 获取id 线程安全
     *
     * @return
     */
    public synchronized long nextId() {
        long timestamp = timeGen();
        // 时间错误
        if (timestamp < lastTimestamp) {
            throw new IllegalStateException("Clock moved backwards.");
        }
        // 当前毫秒内，则+1
        if (lastTimestamp == timestamp) {
            // 当前毫秒内计数满了，则等待下一秒
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        // 偏移组合生成最终的ID，并返回
        long id = ((timestamp - idepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
        return id;
    }

    /**
     * 等待下一个毫秒的到来
     *
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

}
