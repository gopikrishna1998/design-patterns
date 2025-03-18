// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }
}

class PaypalPayment implements PaymentStrategy {
    private String emailId;
    private String password;

    public PaypalPayment(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}

// Context
class ShoppingCart {
    private List<Integer> items;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(int item) {
        this.items.add(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (int item : items) {
            sum += item;
        }
        return sum;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        int amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}

// Client Code
public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(100);
        cart.addItem(200);
        cart.addItem(50);

        PaymentStrategy creditCardPayment = new CreditCardPayment("John Doe", "1234567890123456", "123", "12/23");
        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout();

        PaymentStrategy paypalPayment = new PaypalPayment("john.doe@example.com", "password");
        cart.setPaymentStrategy(paypalPayment);
        cart.checkout();
    }
}
