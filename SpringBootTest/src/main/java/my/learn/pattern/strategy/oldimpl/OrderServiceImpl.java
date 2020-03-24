package my.learn.pattern.strategy.oldimpl;

import my.learn.pattern.strategy.IOrderService;
import my.learn.pattern.strategy.Order;
import org.springframework.stereotype.Service;

/**
 * 订单实现类
 *
 * @author lin
 * @return
 * @date 2019/11/25 16:46
 **/
@Service("oldServiceImpl")
public class OrderServiceImpl implements IOrderService {
    /**
     * 根据订单类型做处理，需要 if else
     *
     * @param order
     * @return
     * @author lin
     * @date 2019/11/25 16:46
     **/
    @Override
    public String handle(Order order) {
        String type = order.getType();
        if ("1".equals(type)) {
            return "普通订单";
        } else if ("2".equals(type)) {
            return "团购订单";
        } else if ("3".equals(type)) {
            return "促销订单";
        }
        return "未知订单";
    }
}
