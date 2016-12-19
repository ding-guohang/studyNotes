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
    private StateMachine<StateEnum, EventEnum> enumStateMachine;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("begin to event one");
        enumStateMachine.sendEvent(EventEnum.Event_One);
        System.out.println("this state = " + enumStateMachine.getState().getIds());

        System.out.println("begin to event two");
        enumStateMachine.sendEvent(EventEnum.Event_Two);
        System.out.println("this state = " + enumStateMachine.getState().getIds());

        System.out.println("begin to event one");
        enumStateMachine.sendEvent(EventEnum.Event_One);
        System.out.println("this state = " + enumStateMachine.getState().getIds() + " " + enumStateMachine.getState().isSubmachineState());

        System.out.println("begin to event one in");
        enumStateMachine.sendEvent(EventEnum.Event_One_In);
        System.out.println("this state = " + enumStateMachine.getState().getIds() + " " + enumStateMachine.getState().isSubmachineState());

        System.out.println("begin to event one in 2");
        enumStateMachine.sendEvent(EventEnum.Event_One_In_2);
        System.out.println("this state = " + enumStateMachine.getState().getIds() + " " + enumStateMachine.getState().isSubmachineState());

        System.out.println("begin to event one external in");
        enumStateMachine.sendEvent(EventEnum.Event_One_External_In);
        System.out.println("this state = " + enumStateMachine.getState().getIds() + " " + enumStateMachine.getState().isSubmachineState());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
