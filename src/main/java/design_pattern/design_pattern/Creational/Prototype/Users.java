package design_pattern.design_pattern.Creational.Prototype;

import java.util.ArrayList;
import java.util.List;
public class Users implements Cloneable{
    private List<String> empList;

    public Users(){
      empList = new ArrayList<>();
    }

    public Users(List<String> list){
        this.empList=list;
    }

    public void loadData(){
        empList.add("Test1");
        empList.add("Test2");
    }

    public List<String> getUsersList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<String> temp = new ArrayList<String>();
        for(String s : this.getUsersList()){
            temp.add(s);
        }
        return new Users(temp);
    }
}