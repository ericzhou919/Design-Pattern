## 定義

將請求封裝為物件，使你藉由不同的請求(佇列或日誌請求)，對客戶端請求參數化，並支援可取消的操作。

## 例子   

> 手機可以進行開機關機、提高或降低音量等操作。  
  
## 程式碼範例  
建立IPhone相關操作。
```java
public class IPhone {
   public void turnOn() {
      System.out.println("IPhone is on");
   }

   public void turnOff() {
      System.out.println("IPhone is off");
   }

   public void increaseVolume() {
      System.out.println("The volume has been increased");
   }

   public void decreaseVolume() {
      System.out.println("The volume has been decreased");
   }
}
```  

建立抽象介面Command。  
```java
public abstract class Command {
    IPhone iphone;
    public Command(IPhone iphone) {
        this.iphone = iphone;
    }
    public abstract void execute();
}
```   

實作相關操作。  
```java
public class TurnOn extends Command {
   public TurnOn(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.turnOn();
   }
}

public class TurnOff extends Command {
   public TurnOff(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.turnOff();
   }
}

public class IncreaseVolume extends Command {
   public IncreaseVolume(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.increaseVolume();
   }
}

public class DecreaseVolume extends Command {
   public DecreaseVolume(IPhone iphone) {
      super(iphone);
   }

   @Override
   public void execute() {
      iphone.decreaseVolume();
   }
}
```  

建立Invoker。
```java
public class Invoker {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
```  
程式執行：  
```java
IPhone i = new IPhone();
Invoker invoker = new Invoker();

invoker.addCommand(new TurnOn(i));
invoker.addCommand(new IncreaseVolume(i));
invoker.addCommand(new DecreaseVolume(i));
invoker.addCommand(new TurnOff(i));

invoker.execute();
```  

輸出：  
```java
IPhone is on
The volume has been increased
The volume has been decreased
IPhone is off
```
