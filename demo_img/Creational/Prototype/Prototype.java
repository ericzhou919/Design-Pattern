package design_pattern.design_pattern.Creational.Prototype;

import java.util.List;

public class Prototype 
{
    public static void UsePrototype() throws CloneNotSupportedException
    {
        System.out.println("UsePrototype");
        Users _user = new Users();
        _user.loadData();
        Users newUser1 = (Users) _user.clone();
        Users newUser2 = (Users) _user.clone();
        List<String> list1 = newUser1.getUsersList();
        list1.add("Test3");

        List<String> list2 = newUser2.getUsersList();
        list2.remove("Test1");
        System.out.println("_user List: "+ _user.getUsersList());
        System.out.println("newUser1 List: "+ newUser1.getUsersList());
        System.out.println("newUser2 List: "+ newUser2.getUsersList());
    }

}
