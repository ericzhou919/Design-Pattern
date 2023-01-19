## 定義

描述一組對象，它們被視為同一類型對象的單個實例。組合的目的是將對象“組合”成樹結構以表示部分整體層次結構。實施複合模式可以使客戶統一處理各個對象和合成。

## 例子   

> 公司部門由高至低分別有CEO、各部門主管、各部門員工，我們將創建各層級人員並依序print。  
  
## 程式碼範例  
創建Employee。
```java
public class Employee {
   private String name;
   private String dept;
   private int salary;
   private List<Employee> subordinates;

   public Employee(String name, String dept, int sal) {
      this.name = name;
      this.dept = dept;
      this.salary = sal;
      subordinates = new ArrayList<Employee>();
   }

   public void add(Employee e) {
      subordinates.add(e);
   }

   public void remove(Employee e) {
      subordinates.remove(e);
   }

   public void traversel(Employee e) {
      if (e.getSubordinates() != null) {
         for (Employee tmpE : e.getSubordinates()) {
            System.out.println(tmpE);
            forEach(tmpE);
         }
      }
   }

   public List<Employee> getSubordinates() {
      return subordinates;
   }

   public String toString() {
      return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]");
   }
}
```   

程式執行：  
```java
Employee CEO = new Employee("BOSS", "CEO", 30000);

Employee headSales = new Employee("Head S", "Head Sales", 20000);

Employee headMarketing = new Employee("Head M", "Head Marketing", 20000);

Employee clerk1 = new Employee("M1", "Marketing", 10000);
Employee clerk2 = new Employee("M2", "Marketing", 10000);

Employee sales1 = new Employee("S1", "Sales", 10000);
Employee sales2 = new Employee("S2", "Sales", 10000);

CEO.add(headSales);
CEO.add(headMarketing);

headSales.add(sales1);
headSales.add(sales2);

headMarketing.add(clerk1);
headMarketing.add(clerk2);

System.out.println(CEO);
CEO.traversel(CEO);
```  

輸出：  
```java
Employee :[ Name : BOSS, dept : CEO, salary :30000 ]
Employee :[ Name : Head S, dept : Head Sales, salary :20000 ]
Employee :[ Name : S1, dept : Sales, salary :10000 ]
Employee :[ Name : S2, dept : Sales, salary :10000 ]
Employee :[ Name : Head M, dept : Head Marketing, salary :20000 ]
Employee :[ Name : M1, dept : Marketing, salary :10000 ]
Employee :[ Name : M2, dept : Marketing, salary :10000 ]
```
