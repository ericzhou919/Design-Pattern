package design_pattern.design_pattern.Behavioral.Command;

public abstract class Command {

    IPhone iphone;

    public Command(IPhone iphone) {
        this.iphone = iphone;
    }

    public abstract void execute();
}
