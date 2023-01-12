## 定義

在不違反封裝的情況下，補獲一個物件的內部狀態，並在該物件外保存這個狀態，以便之後可以將物件恢復到之前的狀態。

## 例子   

> Memento Pattern由兩個物件實現：Originator 和 Caretaker。Originator是一個具有內部狀態的物件。Caretaker對Originator執行操作，但在需要時可以撤銷更改。例如Word的編輯器(Caretaker)及內容文字(Originator)。
  
## 程式碼範例  
創建 Memento。  
```java
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
```  

創建 Originator。  
```java
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
```   

創建 CareTaker。  
```java
import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
```  

程式執行：  
```java
Originator originator = new Originator();
CareTaker careTaker = new CareTaker();

originator.setState("State #1");
originator.setState("State #2");
careTaker.add(originator.saveStateToMemento());

originator.setState("State #3");
careTaker.add(originator.saveStateToMemento());

originator.setState("State #4");
System.out.println("Current State: " + originator.getState());

originator.getStateFromMemento(careTaker.get(0));
System.out.println("First saved State: " + originator.getState());
originator.getStateFromMemento(careTaker.get(1));
System.out.println("Second saved State: " + originator.getState());
```  

輸出：  
```java
Current State: State #4
First saved State: State #2
Second saved State: State #3
```
