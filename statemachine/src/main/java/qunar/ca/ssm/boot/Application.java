package qunar.ca.ssm.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import qunar.ca.ssm.EventEnum;
import qunar.ca.ssm.StateEnum;

import javax.annotation.Resource;

/**
 * @author guohang.ding on 16-12-15
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private StateMachine<StateEnum, EventEnum> stateMachine;

    @Override
    public void run(String... strings) throws Exception {
        stateMachine.sendEvent(EventEnum.Event_One);
        stateMachine.sendEvent(EventEnum.Event_Two);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
