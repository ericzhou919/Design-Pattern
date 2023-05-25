## Definition

The complex subsystem is encapsulated behind a simple interface, which hides many complexities and makes the subsystem easy to use.  

## Example

> Assuming we want to start a car, which involves many complex operations, the Facade Pattern allows us to achieve it with just 2 lines of code.  

## Programmatic Example

Many complex operations.  

```java
public class CarEngineFacade {
    private static final Integer DEFAULT_COOLING_TEMP = 90;
    private static final Integer MAX_ALLOWED_TEMP = 50;
    private FuelInjector fuelInjector = new FuelInjector();
    private AirFlowController airFlowController = new AirFlowController();
    private Starter starter = new Starter();
    private CoolingController coolingController = new CoolingController();
    private CatalyticConverter catalyticConverter = new CatalyticConverter();

    public void startEngine() {
        fuelInjector.on();
        airFlowController.takeAir();
        fuelInjector.on();
        fuelInjector.inject();
        starter.start();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
        catalyticConverter.on();
    }

    public void stopEngine() {
        fuelInjector.off();
        catalyticConverter.off();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
        airFlowController.off();
    }
}
```

Program execution：

```java
CarEngineFacade c = new CarEngineFacade();
c.startEngine();
System.out.println("");
c.stopEngine();
```

Program output：

```java
Getting air measurements..
Air provided!
Fuel injector ready to inject fuel.
Fuel Pump is pumping fuel..
Fuel injected.
Starting..
Setting temperature upper limit to 90
Cooling Controller ready!
Setting radiator speed to 10
Catalytic Converter switched on!

Stopping Fuel injector..
Catalytic Converter switched off!
Scheduled cooling with maximum allowed temperature 50
Getting temperature from the sensor..
Radiator switched on!
Stopping Cooling Controller..
Radiator switched off!
Air controller switched off.
```
