package core.proxy;

public class RealService implements Service {
    @Override
    public void execute() {
        System.out.println("RealService execute");
    }
}
