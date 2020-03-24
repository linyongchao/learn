package my.learn.pattern.strategy;

/**
 * 订单接口
 *
 * @author lin
 * @return
 * @date 2019/11/25 16:44
 **/
public interface IOrderService {

    /**
     * 根据订单类型做对应的处理
     *
     * @param order
     * @return
     * @author lin
     * @date 2019/11/25 16:44
     **/
    String handle(Order order);
}
