package my.learn.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 订单类
 *
 * @author lin
 * @return
 * @date 2019/11/25 16:38
 **/
@Data
@AllArgsConstructor
public class Order {
    /**
     * 订单类型
     * 1. 普通订单
     * 2. 团购订单
     * 3. 促销订单
     **/
    private String type;

}
