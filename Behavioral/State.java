// State Interface
interface TrafficLightState {
    void handle(TrafficLight context);
}

// Concrete States
class RedState implements TrafficLightState {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("Traffic Light: Red");
        try {
            Thread.sleep(2000); // Simulate red light duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.setState(new GreenState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("Traffic Light: Yellow");
        try {
            Thread.sleep(1000); // Simulate yellow light duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.setState(new RedState());
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("Traffic Light: Green");
        try {
            Thread.sleep(3000); // Simulate green light duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.setState(new YellowState());
    }
}

// Context
class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        state = new RedState(); // Initial state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void changeState() {
        state.handle(this);
    }
}

// Client Code
public class StateDemo {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        for (int i = 0; i < 5; i++) {
            trafficLight.changeState();
        }
    }
}
