// 1. Abstract Expression
interface Expression {
    boolean interpret();
}

// 2. Terminal Expressions
class TrueExpression implements Expression {
    public boolean interpret() {
        return true;
    }
}

class FalseExpression implements Expression {
    public boolean interpret() {
        return false;
    }
}

// 3. Non-terminal Expressions
class AndExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret() {
        return expr1.interpret() && expr2.interpret();
    }
}

class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret() {
        return expr1.interpret() || expr2.interpret();
    }
}

public class InterpreterPatternDemo {
    public static void main(String[] args) {
        Expression trueExp = new TrueExpression();
        Expression falseExp = new FalseExpression();

        Expression andExp = new AndExpression(trueExp, falseExp);
        Expression orExp = new OrExpression(trueExp, falseExp);

        System.out.println("true AND false: " + andExp.interpret());  // false
        System.out.println("true OR false: " + orExp.interpret());    // true
    }
}
