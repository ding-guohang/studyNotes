package qunar.ca.ssm;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

/**
 * @author guohang.ding on 16-12-14
 */
public class SSMDemo {

    public static StateMachine<StateEnum, EventEnum> buildMachine() throws Exception {
        StateMachineBuilder.Builder<StateEnum, EventEnum> builder = StateMachineBuilder.builder();

        builder.configureStates()
                .withStates()
                .initial(StateEnum.State_One)
                .states(EnumSet.allOf(StateEnum.class));
        builder.configureTransitions()
                .withExternal()
                .source(StateEnum.State_One).target(StateEnum.State_Two)
                .event(EventEnum.Event_One)
                .and()
                .withExternal()
                .source(StateEnum.State_Two).target(StateEnum.State_One)
                .event(EventEnum.Event_Two);

        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        StateMachine<StateEnum, EventEnum> stateMachine = buildMachine();
        stateMachine.start();
        stateMachine.sendEvent(EventEnum.Event_One);
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(EventEnum.Event_Two);
        System.out.println(stateMachine.getState());
    }
}
