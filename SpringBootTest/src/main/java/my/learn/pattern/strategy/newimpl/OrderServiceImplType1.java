package my.learn.pattern.strategy.newimpl;

import my.learn.pattern.strategy.Order;
import org.springframework.stereotype.Service;

@Service
@OrderType("1")
public class OrderServiceImplType1 extends OrderAbstractImpl {
    @Override
    public String handle(Order order) {
        return "普通订单";
    }
}
