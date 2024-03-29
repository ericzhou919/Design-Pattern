package design_pattern.design_pattern;

import design_pattern.design_pattern.Creational.AbstractFactory.*;
import design_pattern.design_pattern.Creational.Factory.Factory;
import design_pattern.design_pattern.Creational.ObjectPool.ObjectPoolPatterns;
import design_pattern.design_pattern.Creational.Prototype.Prototype;
import design_pattern.design_pattern.Creational.Singleton.Singleton;
import design_pattern.design_pattern.Creational.AbstractFactory.AbstractFactory;
import design_pattern.design_pattern.Creational.Builder.BuilderPattern;
import design_pattern.design_pattern.Creational.Multiton.*;
import design_pattern.design_pattern.Structural.Adapter.*;

import java.io.IOException;

import design_pattern.design_pattern.Behavioral.ChainOfResponsibility.*;
import design_pattern.design_pattern.Behavioral.Iterator.*;
import design_pattern.design_pattern.Behavioral.Observer.*;
import design_pattern.design_pattern.Behavioral.Ｍemento.*;
import design_pattern.design_pattern.Behavioral.Strategy.*;
import design_pattern.design_pattern.Behavioral.TemplateMethod.*;
import design_pattern.design_pattern.Behavioral.Command.*;
import design_pattern.design_pattern.Behavioral.Visitor.*;
import design_pattern.design_pattern.Structural.Proxy.*;
import design_pattern.design_pattern.Concurrency.ActiveObject.*;
import design_pattern.design_pattern.Concurrency.ThreadPool.*;
import design_pattern.design_pattern.Concurrency.ReadWriteLock.*;
import design_pattern.design_pattern.Concurrency.GuardedSuspension.*;
import design_pattern.design_pattern.Concurrency.DoubleCheckedLocking.*;
import design_pattern.design_pattern.Concurrency.Reactor.*;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException, IOException {
        ActiveObjectPattern.UseActiveObject();
    }
}
