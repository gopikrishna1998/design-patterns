// Target Interface (Celsius)
interface TemperatureInCelsius {
    double getTemperatureInCelsius();
}

// Adaptee (Fahrenheit)
class TemperatureInFahrenheit {
    private double temperature;

    public TemperatureInFahrenheit(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperatureInFahrenheit() {
        return temperature;
    }
}

// Adapter
class FahrenheitToCelsiusAdapter implements TemperatureInCelsius {
    private TemperatureInFahrenheit fahrenheitTemperature;

    public FahrenheitToCelsiusAdapter(TemperatureInFahrenheit fahrenheitTemperature) {
        this.fahrenheitTemperature = fahrenheitTemperature;
    }

    @Override
    public double getTemperatureInCelsius() {
        double fahrenheit = fahrenheitTemperature.getTemperatureInFahrenheit();
        return (fahrenheit - 32) * 5 / 9;
    }
}

// Client Code
public class AdapterDemo {
    public static void main(String[] args) {
        TemperatureInFahrenheit fahrenheitTemp = new TemperatureInFahrenheit(68); // 68 degrees Fahrenheit
        FahrenheitToCelsiusAdapter adapter = new FahrenheitToCelsiusAdapter(fahrenheitTemp);

        double celsiusTemp = adapter.getTemperatureInCelsius();
        System.out.println("Temperature in Celsius: " + celsiusTemp);
    }
}
