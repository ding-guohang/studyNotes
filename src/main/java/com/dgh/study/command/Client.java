package com.dgh.study.command;

/**
 * 模拟客户角色
 *
 * @author guohang.ding on 16-11-15
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("client want to add page");
        Invoker invoker = new Invoker();
        Command command = new AddPageCommand();
        invoker.setCommand(command);
        System.out.println("client finish add command");
        invoker.action();
    }
}
