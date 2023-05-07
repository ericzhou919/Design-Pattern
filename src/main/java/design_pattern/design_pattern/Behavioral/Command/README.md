## Definition

Encapsulate requests into objects to parameterize clients with different types of requests (queue or log requests), and support cancellable operations.

## Example

> A mobile phone can perform operations such as power on/off and adjusting the volume up or down.

## Programmatic Example

Create iPhone-related operations.

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

Create an abstract interface "Command".

```java
public abstract class Command {
    IPhone iphone;
    public Command(IPhone iphone) {
        this.iphone = iphone;
    }
    public abstract void execute();
}
```

Implement related operations.

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

Create Invoker。

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

Program execution：

```java
IPhone i = new IPhone();
Invoker invoker = new Invoker();

invoker.addCommand(new TurnOn(i));
invoker.addCommand(new IncreaseVolume(i));
invoker.addCommand(new DecreaseVolume(i));
invoker.addCommand(new TurnOff(i));

invoker.execute();
```

Program output：

```java
IPhone is on
The volume has been increased
The volume has been decreased
IPhone is off
```
