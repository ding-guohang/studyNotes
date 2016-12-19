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
@EnableStateMachine(name = "enumStateMachine")
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

    /**
     * withStates触发分层, 每层只有一个Initial, parent指定父状态
     * states就是遍历state
     *
     * @param states params
     * @throws Exception if configuration error happens
     */
    @Override
    public void configure(StateMachineStateConfigurer<StateEnum, EventEnum> states) throws Exception {
        states
                .withStates()
                .initial(StateEnum.State_One)// 每一层只能有一个initial
                .end(StateEnum.State_End)
                .states(EnumSet.allOf(StateEnum.class))
                .and()
                .withStates()// 通过withStates完成分层 todo 分层如何使用？又有什么场景用得上？
                    .parent(StateEnum.State_One)// 父状态
                    .initial(StateEnum.State_One_S1)
                //In every state, you can include a clause [event list]/defer.
                //If an event in the current state’s deferred event list occurs,
                // the event will be saved (deferred) for future processing
                // until a state is entered that does not list the event in its deferred event list
                    .state(StateEnum.State_One_S2)// 可以指定Event Deferral 某些事件不能在这个状态执行，但是可以被推迟等待下一个状态再执行
                    .and()
                .withStates()
                    .parent(StateEnum.State_Two)
                    .initial(StateEnum.State_Two_S1)
                    .state(StateEnum.State_Two_S2)
                ;
    }

    /**
     * Transition 由Event或者Timer触发
     *
     * @param transitions External, Internal, Local
     * @throws Exception if configuration error happens
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions) throws Exception {
        transitions
                .withExternal()// 通常意义上我们所理解的状态转换和他们做的事情
                    .source(StateEnum.State_One)
                    .target(StateEnum.State_Two)
                    .event(EventEnum.Event_One)
                    .and()
                .withExternal()
                    .source(StateEnum.State_Two)
                    .target(StateEnum.State_One)
                    .event(EventEnum.Event_One)
                    .and()
                .withInternal()// 一些不会转换状态机状态的事情，
                // it is identical with self-transition in the absence of state entry and exit actions.
                // 和没有进出Action的自我状态转换一样
                    .source(StateEnum.State_Two)
                    .event(EventEnum.Event_Two)
                    .and()
                .withLocal()// 不会转换到子状态, Still State_One, excuse me?
                    .source(StateEnum.State_One)
                    .target(StateEnum.State_One_S2)
                    .event(EventEnum.Event_One_In)
                    .and()
                .withLocal()
                    .source(StateEnum.State_One)
                    .target(StateEnum.State_Two)
                    .event(EventEnum.Event_Two_In)
                    .and()
                .withExternal()
                    .source(StateEnum.State_One_S2)
                    .target(StateEnum.State_One_S1)
                    .event(EventEnum.Event_One_In_2)
                    .and()
                .withExternal()
                    .source(StateEnum.State_Two)
                    .target(StateEnum.State_Two_S2)
                    .event(EventEnum.Event_Two_External_In)
                    .and()
                .withExternal()
                    .source(StateEnum.State_One)
                    .target(StateEnum.State_Two_S2)
                    .event(EventEnum.Event_Two_External_In)
        ;
    }

    @Bean
    public StateMachineListener<StateEnum, EventEnum> listener() {
        return new StateMachineListenerAdapter<StateEnum, EventEnum>() {
            @Override
            public void stateChanged(State<StateEnum, EventEnum> from, State<StateEnum, EventEnum> to) {
                if (to == null || from == null) {
//                    System.out.println("from == null? " + (from == null) + ", to == null? " + (to == null));
                    return;
                }
//                System.out.println("State from " + from.getId() + " change to " + to.getId());
            }

            @Override
            public void transition(Transition<StateEnum, EventEnum> transition) {
//                System.out.println("transition happened");
            }
        };
    }
}
