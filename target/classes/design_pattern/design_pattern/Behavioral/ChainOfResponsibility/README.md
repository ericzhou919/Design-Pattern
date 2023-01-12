## 定義

使多個物件都有機會處理請求，從而避免請求的發送者和接收者之間的耦合關係。將這個物件連成一條鏈，並沿著這條鏈傳遞該請求，直到有一個物件處理它為止。

## 例子   

> 你是一名新兵，正在新訓中心接受訓練，任何要求需要獲得長官批准才能去做。  
  
## 程式碼範例  
建立抽象類別 Sir。
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

實作班長、排長、連長。  
```java
class SquadLeader extends Sir {
   // 班長
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
   // 排長
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
   // 連長
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

程式執行：  
```java
Sir SquadLeader = new SquadLeader();
Sir PlatoonLeader = new PlatoonLeader();
Sir CompanyLeader = new CompanyLeader();
SquadLeader.setNext(PlatoonLeader);
PlatoonLeader.setNext(CompanyLeader);

//放入不同等級的Request
SquadLeader.handleRequest(1);
SquadLeader.handleRequest(2);
SquadLeader.handleRequest(3);
SquadLeader.handleRequest(4);
```  

輸出：  
```java
SquadLeader approve your level 1 request.
PlatoonLeader approve your level 2 request.
CompanyLeader approve your level 3 request.
No one has the right to approve.
```
