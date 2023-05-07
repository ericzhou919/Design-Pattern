## Definition

Allow multiple objects to have a chance to handle a request, thus avoiding coupling between the sender and receiver of the request. Connect these objects into a chain and pass the request along the chain until an object handles it.

## Example

> You are a new recruit undergoing training at the training center, and any requests must be approved by the commanding officer before you can proceed.

## Programmatic Example

Create an abstract class Sir。

```java
abstract class Sir {
   private Sir next;
   private String name;

   public Sir(String name) {
      this.name = name;
   }

   public void setNext(Sir next) {
      this.next = next;
   }

   public Sir getNext() {
      return next;
   }

   public void requestSuccesses(int LeaveDays) {
      System.out.println(this.name + " approve your level " + LeaveDays + " request.");
   }

   public void requestFailed() {
      System.out.println("No one has the right to approve.");
   }

   public abstract void handleRequest(int LeaveDays);
}
```

Implement SquadLeader,PlatoonLeader,CompanyLeader.

```java
class SquadLeader extends Sir {
   public SquadLeader() {
      super("SquadLeader");
   }

   public void handleRequest(int requestLevel) {
      if (requestLevel <= 1) {
         this.requestSuccesses(requestLevel);
      } else {
         if (getNext() != null) {
            getNext().handleRequest(requestLevel);
         } else {
            this.requestFailed();
         }
      }
   }
}

class PlatoonLeader extends Sir {
   public PlatoonLeader() {
      super("PlatoonLeader");
   }

   public void handleRequest(int requestLevel) {
      if (requestLevel <= 2) {
         this.requestSuccesses(requestLevel);
      } else {
         if (getNext() != null) {
            getNext().handleRequest(requestLevel);
         } else {
            this.requestFailed();
         }
      }
   }
}

class CompanyLeader extends Sir {
   public CompanyLeader() {
      super("CompanyLeader");
   }

   public void handleRequest(int requestLevel) {
      if (requestLevel <= 3) {
         this.requestSuccesses(requestLevel);
      } else {
         if (getNext() != null) {
            getNext().handleRequest(requestLevel);
         } else {
            this.requestFailed();
         }
      }
   }
}
```

Program execution：

```java
Sir SquadLeader = new SquadLeader();
Sir PlatoonLeader = new PlatoonLeader();
Sir CompanyLeader = new CompanyLeader();
SquadLeader.setNext(PlatoonLeader);
PlatoonLeader.setNext(CompanyLeader);

SquadLeader.handleRequest(1);
SquadLeader.handleRequest(2);
SquadLeader.handleRequest(3);
SquadLeader.handleRequest(4);
```

Program output：

```java
SquadLeader approve your level 1 request.
PlatoonLeader approve your level 2 request.
CompanyLeader approve your level 3 request.
No one has the right to approve.
```
