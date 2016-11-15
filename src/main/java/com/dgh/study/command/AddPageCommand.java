package com.dgh.study.command;

/**
 * 命令实例举例……
 *
 * @author guohang.ding on 16-11-15
 */
public class AddPageCommand implements Command<Boolean> {

    private RequirementGroup requirement;
    private FEGroup fe;

    public AddPageCommand() {
        // 这里其实可以接入工厂模式，不过这次就是举例说明命令模式而已，不用在意
        this.requirement = new RequirementGroup();
        this.fe = new FEGroup();
    }

    public Boolean execute() {
        requirement.doSomething();
        fe.doSomething();
        return true;
    }
}
