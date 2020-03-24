package my.learn.pattern.strategy;

import my.learn.pattern.strategy.newimpl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewImplTest {
    // 1. 定义注解
    // 2. 定义订单的抽象实现
    // 3. 定义各个注解类型的实现
    // 4. 扫描注解工具类
    // 5. 扫描所有含有特定注解的类，然后构造实现类
    // 6. 用实现类执行处理

    @Autowired
    OrderServiceImpl orderService;

    @Test
    public void test() {
        Order order1 = new Order("1");
        System.out.println(orderService.handle(order1));
        Order order2 = new Order("2");
        System.out.println(orderService.handle(order2));
        Order order3 = new Order("3");
        System.out.println(orderService.handle(order3));
        Order order4 = new Order("4");
        System.out.println(orderService.handle(order4));
    }

}
