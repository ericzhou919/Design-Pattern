## Definition

Describe a group of objects that are treated as individual instances of the same type of object. The purpose of composition is to "compose" these objects into a tree structure to represent a hierarchical structure of parts and wholes. Implementing the composite pattern enables clients to handle individual objects and compositions uniformly.

## Example

> The company's departments from high to low have CEOs, department heads, and employees of each department. We will create personnel at each level and print them in order.

## Programmatic Example

Create Employee。

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

Program execution：

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

Program output：

```java
Employee :[ Name : BOSS, dept : CEO, salary :30000 ]
Employee :[ Name : Head S, dept : Head Sales, salary :20000 ]
Employee :[ Name : S1, dept : Sales, salary :10000 ]
Employee :[ Name : S2, dept : Sales, salary :10000 ]
Employee :[ Name : Head M, dept : Head Marketing, salary :20000 ]
Employee :[ Name : M1, dept : Marketing, salary :10000 ]
Employee :[ Name : M2, dept : Marketing, salary :10000 ]
```
