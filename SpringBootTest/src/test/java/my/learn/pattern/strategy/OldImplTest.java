package my.learn.pattern.strategy;

import my.learn.StartSpringBoot;
import my.learn.pattern.strategy.oldimpl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartSpringBoot.class)
public class OldImplTest {
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
