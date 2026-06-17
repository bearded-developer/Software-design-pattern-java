/**
 * 📖 Interpreter Pattern
 * 
 * Story: A calculator that understands "five plus three" or "ten minus two".
 * You define a mini-language with grammar rules, and the interpreter evaluates it.
 * 
 * What it does: Given a language, defines a grammar and an interpreter that
 * evaluates sentences in that language.
 */

import java.util.Stack;

// 1. Expression Interface
interface Expression {
    int interpret();
}

// 2. Terminal Expressions
class NumberExpression implements Expression {
    private int number;
    public NumberExpression(int number) { this.number = number; }
    public int interpret() { return number; }
}

// 3. Non-Terminal Expressions
class AddExpression implements Expression {
    private Expression left, right;
    public AddExpression(Expression left, Expression right) { this.left = left; this.right = right; }
    public int interpret() { return left.interpret() + right.interpret(); }
}

class SubtractExpression implements Expression {
    private Expression left, right;
    public SubtractExpression(Expression left, Expression right) { this.left = left; this.right = right; }
    public int interpret() { return left.interpret() - right.interpret(); }
}

class MultiplyExpression implements Expression {
    private Expression left, right;
    public MultiplyExpression(Expression left, Expression right) { this.left = left; this.right = right; }
    public int interpret() { return left.interpret() * right.interpret(); }
}

// 4. Parser
class CalculatorParser {
    public static Expression parse(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Expression> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                Expression right = stack.pop();
                Expression left = new NumberExpression(Integer.parseInt(tokens[++i]));
                stack.push(new AddExpression(left, right));
            } else if (tokens[i].equals("-")) {
                Expression right = stack.pop();
                Expression left = new NumberExpression(Integer.parseInt(tokens[++i]));
                stack.push(new SubtractExpression(left, right));
            } else if (tokens[i].equals("*")) {
                Expression right = stack.pop();
                Expression left = new NumberExpression(Integer.parseInt(tokens[++i]));
                stack.push(new MultiplyExpression(left, right));
            } else {
                stack.push(new NumberExpression(Integer.parseInt(tokens[i])));
            }
        }
        return stack.pop();
    }
}

// 5. Demo
public class InterpreterPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Interpreter Pattern Demo               ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        String[] expressions = {"3 4 +", "10 5 -", "5 3 *", "10 2 + 3 -"};
        
        for (String exp : expressions) {
            Expression parsed = CalculatorParser.parse(exp);
            int result = parsed.interpret();
            System.out.println("   " + exp + " = " + result);
        }
        
        System.out.println("\n💡 We created a mini-language and interpreted it!");
    }
}