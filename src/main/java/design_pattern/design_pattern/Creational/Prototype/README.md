## 定義

通過複製一個已經存在的實例來返回新的實例，而不是新建實例。

## 例子   

> 創建新的UserList時，從舊的UserList使用Clone。  
  
## 程式碼範例  
```java
public class Users implements Cloneable{
    private List<String> empList;

    public Users(){
      empList = new ArrayList<>();
    }

    public Users(List<String> list){
        this.empList=list;
    }

    public void initData(){
        empList.add("Test1");
        empList.add("Test2");
    }

    public List<String> getUsersList() {
        return empList;
    }
    
    public void add(String s) {
        empList.add(s);
    }
    
    public void remove(String s) {
        if (empList.contains(s)) 
            empList.remove(s);
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
```   

程式執行：  
```java
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
```  

輸出：  
```java
newUser1 clone by userList
newUser2 clone by userList
newUser1 add Test3
newUser2 remove Test1
User List: [Test1, Test2]
newUser1 List: [Test1, Test2, Test3]
newUser2 List: [Test2]
```
