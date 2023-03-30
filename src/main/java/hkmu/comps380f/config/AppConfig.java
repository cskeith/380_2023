package hkmu.comps380f.config;

import hkmu.comps380f.CalPowerSpring;
import hkmu.comps380f.CalculateSpring;
import hkmu.comps380f.CollectionSpring;
import hkmu.comps380f.aspect.LoggingAspect;
import hkmu.comps380f.op.OpAdd;
import hkmu.comps380f.op.OpMultiply;
import hkmu.comps380f.op.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public Operation multiply() {
        return new OpMultiply();
    }

    @Bean
    public Operation add() {
        return new OpAdd();
    }

    /* Example 2 */
    @Bean
    public CalculateSpring opsbean() {
        CalculateSpring opsbean = new CalculateSpring();
        opsbean.setOps(add());
        return opsbean;
    }

    /* Example 3 */
    @Bean
    public CalPowerSpring powerOpsBean() {
        return new CalPowerSpring(5, add());
    }

    /* Example 4 */
    @Bean
    public CalculateSpring opsWithInnerBean() {
        CalculateSpring opsWithInnerBean = new CalculateSpring();
        opsWithInnerBean.setOps(new OpAdd());
        return opsWithInnerBean;
    }

    /* List example */
    @Bean
    public CollectionSpring listBean() {
        CollectionSpring listBean = new CollectionSpring();
        listBean.setOps(Arrays.asList(add(), multiply(), add()));
        return listBean;
    }

    /* Set example */
    @Bean
    public CollectionSpring setBean() {
        CollectionSpring setBean = new CollectionSpring();
        setBean.setOps(new HashSet<>(Arrays.asList(add(), multiply(), add())));
        return setBean;
    }

    /* Aspect example */
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
