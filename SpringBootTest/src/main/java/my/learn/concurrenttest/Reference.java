package my.learn.concurrenttest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 序列号自增且时间更新为最新的时间戳
 **/
@Data
@AllArgsConstructor
public class Reference {
    /**
     * 序号
     **/
    private long sequence;
    /**
     * 时间戳
     **/
    private long timestamp;
}
