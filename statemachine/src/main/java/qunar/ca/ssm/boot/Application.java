package qunar.ca.ssm.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import qunar.ca.ssm.EventEnum;
import qunar.ca.ssm.StateEnum;

import javax.annotation.Resource;

/**
 * @author guohang.ding on 16-12-15
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Resource
    private StateMachine<StateEnum, EventEnum> enumStateMachine;

    @Override
    public void run(String... strings) throws Exception {

        State now = enumStateMachine.getState();
        enumStateMachine.sendEvent(EventEnum.Event_One);
        print(now, EventEnum.Event_One, enumStateMachine.getState());

        now = enumStateMachine.getState();
        enumStateMachine.sendEvent(EventEnum.Event_One);
        print(now, EventEnum.Event_One, enumStateMachine.getState());

        now = enumStateMachine.getState();
        enumStateMachine.sendEvent(EventEnum.Event_One_In);
        print(now, EventEnum.Event_One_In, enumStateMachine.getState());

        now = enumStateMachine.getState();
        enumStateMachine.sendEvent(EventEnum.Event_One_In_2);
        print(now, EventEnum.Event_One_In_2, enumStateMachine.getState());

        now = enumStateMachine.getState();
        enumStateMachine.sendEvent(EventEnum.Event_Two_In);
        print(now, EventEnum.Event_Two_In, enumStateMachine.getState());

        now = enumStateMachine.getState();
        enumStateMachine.sendEvent(EventEnum.Event_Two_External_In);
        print(now, EventEnum.Event_Two_External_In, enumStateMachine.getState());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private static void print(State before, EventEnum event, State now) {
        String template = "this state is %s, use event %s, end is %s, is sub state?%s";

        System.out.println(String.format(template, before.getId(), event,
                now.getId(), now.isSubmachineState()));
    }
}
