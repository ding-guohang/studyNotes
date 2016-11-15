/**
 * 中介者模式
 *
 * Definition:
 * Define an object that encapsulates how a set of objects interact. \
 * Mediator promotes loose coupling by keeping objects from referring to
 * each other explicitly and it lets you vary their interaction independently
 *
 * 用中介者去完成需要多个类参与完成的工作，把多个类的相互耦合变成每个类只和中介者耦合……
 *
 * 【场景】
 * 1、类关系是蜘蛛网结构，可以借此改为星形结构
 * 2、类之间的依赖关系尚不确定，或者有可能改变
 *
 * 【劣势】
 * 中介者膨胀，内部逻辑复杂
 *
 * 【举栗】
 * 机场调度中心、MVC中的Controller
 *
 * @author guohang.ding on 16-11-15
 */
package com.dgh.study.mediator;