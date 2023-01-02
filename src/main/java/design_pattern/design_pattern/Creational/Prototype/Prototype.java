package design_pattern.design_pattern.Creational.Prototype;

import java.util.List;

public class Prototype 
{
    public static void UsePrototype() throws CloneNotSupportedException
    {
        Users userList = new Users();
        userList.initData();
        Users newUser1 = (Users) userList.clone();
        System.out.println("newUser1 clone by userList");
        Users newUser2 = (Users) userList.clone();
        System.out.println("newUser2 clone by userList");
        
        newUser1.add("Test3");
        System.out.println("newUser1 add Test3");

        newUser2.remove("Test1");
        System.out.println("newUser2 remove Test1");

        System.out.println("User List: "+ userList.getUsersList());
        System.out.println("newUser1 List: "+ newUser1.getUsersList());
        System.out.println("newUser2 List: "+ newUser2.getUsersList());
    }

}
