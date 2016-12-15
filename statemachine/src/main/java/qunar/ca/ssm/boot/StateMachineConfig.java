package qunar.ca.ssm.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigBuilder;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import qunar.ca.ssm.EventEnum;
import qunar.ca.ssm.StateEnum;

import java.util.EnumSet;

/**
 * @author guohang.ding on 16-12-15
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StateEnum, EventEnum> {

    @Override
    public void configure(StateMachineConfigBuilder<StateEnum, EventEnum> config) throws Exception {
        super.configure(config);
    }

    @Override
    public void configure(StateMachineModelConfigurer<StateEnum, EventEnum> model) throws Exception {
        super.configure(model);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<StateEnum, EventEnum> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<StateEnum, EventEnum> states) throws Exception {
        states
                .withStates()
                .initial(StateEnum.State_One)
                .states(EnumSet.allOf(StateEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions) throws Exception {
        transitions
                .withExternal()
                .source(StateEnum.State_One).target(StateEnum.State_Two).event(EventEnum.Event_One)
                .and()
                .withExternal()
                .source(StateEnum.State_Two).target(StateEnum.State_One).event(EventEnum.Event_Two);
    }

    @Bean
    public StateMachineListener<StateEnum, EventEnum> listener() {
        return new StateMachineListenerAdapter<StateEnum, EventEnum>() {
            @Override
            public void stateChanged(State<StateEnum, EventEnum> from, State<StateEnum, EventEnum> to) {
                if (to == null || from == null) {
                    System.out.println("from == null? " + (from == null) + ", to == null? " + (to == null));
                    return;
                }
                System.out.println("State from " + from.getId() + " change to " + to.getId());
            }

            @Override
            public void transition(Transition<StateEnum, EventEnum> transition) {
                System.out.println("transition happened");
            }
        };
    }
}
