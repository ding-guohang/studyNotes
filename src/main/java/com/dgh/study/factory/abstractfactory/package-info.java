/**
 * 抽象工厂模式
 *
 * 对于抽象工厂来说     |===> 有多少个产品族/种类，就应该有多少个创建的方法，比如createProductA(), createProductB()
 *                    |===> 有多少个产品等级，就应该有多少个实现的工厂，比如AFactory1, AFactory2
 *                    |
 * 对于产品维度来说     |===> 有一个抽象产品作为他们的通用模式
 *                    |===> 每个产品族有自己的抽象工厂子类，包含创建所有等级的方法
 *                    |
 * 抽象工厂模式用处     |===> 使用者只需要知道对应的工厂方法，不需要知道产品的实现类
 *                    |
 *                    |
 * 对于扩展的难易点     |===> 扩展族，需要在抽象工厂里面增加一个方法，例如createC()，修改所有工厂实现类，Hard！
 *                    |===> 扩展等级，只需要创建一个抽象工厂子类，例如CreatorLevel3，Easy！
 *
 * 但是其实我还是不知道有什么Case用得上
 *
 * @author guohang.ding on 16-9-1
 */
package com.dgh.study.factory.abstractfactory;