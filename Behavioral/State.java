// State Interface
interface TrafficLightState {
    void handle(TrafficLight trafficLight);
}

// Concrete States
class RedState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Traffic Light: Red");
        try {
            Thread.sleep(2000); // Simulate red light duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficLight.setState(new GreenState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Traffic Light: Yellow");
        try {
            Thread.sleep(1000); // Simulate yellow light duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficLight.setState(new RedState());
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void handle(TrafficLight trafficLight) {
        System.out.println("Traffic Light: Green");
        try {
            Thread.sleep(3000); // Simulate green light duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficLight.setState(new YellowState());
    }
}

// Context
class TrafficLight {
    private TrafficLightState trafficLightState;

    public TrafficLight() {
        state = new RedState(); // Initial state
    }

    public void setState(TrafficLightState trafficLightState) {
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
