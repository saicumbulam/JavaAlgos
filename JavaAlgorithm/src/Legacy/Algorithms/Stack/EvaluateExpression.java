package Legacy.Algorithms.Stack;

public class EvaluateExpression {
    public int evaluate(String expression){
        String[] tokens = expression.split("");

        // stack for values
        Stack values = new Stack();

        // stack for operators
        genericStack<String> ops = new genericStack<String>();

        for (int i = 0; i < tokens.length; i++) {

            // if there is a space then skip
            if (tokens[i] == " ") {
                continue;
            }

            // Current token is a number, push it to stack for numbers
            if (isNumeric(tokens[i]) == true) {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && isNumeric(tokens[i]) == true ){
                    sbuf.append(tokens[i++]);
                }
                values.push(Integer.parseInt(sbuf.toString()));
            }

            // current token, push it into ops
            else if (tokens[i] == "(" ) {
                ops.push(tokens[i]);
            }

            else if (tokens[i].equals(")")) {
                while (ops.peek() != "(" ){
                    values.push(applyOp(ops.pop(), values.Pop(), values.Pop()));
                }
            }

            // Current token is an operator.
            else if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek()))
                {
                    values.push(applyOp(ops.pop(), values.Pop(), values.Pop()));
                }
                ops.push(tokens[i]);
            }

        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.isEmpty())
            values.push(applyOp(ops.pop(), values.Pop(), values.Pop()));

        // Top of 'values' cont
        return values.Pop();
    }

    public int applyOp(String op, int a, int b)
    {
        switch (op)
        {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a*b;
            case "/":
                if (b == 0) {
                    throw new UnsupportedOperationException(" Division by integer not allowed");
                }
                return a/b;
        }
        return 0;
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public boolean hasPrecedence(String op1, String op2)
    {
        if (op2 == "(" || op2 == ")")
            return false;
        if ((op1 == "*" || op1 == "/") && (op2 == "+" || op2 == "-"))
            return false;
        else
            return true;
    }

    public boolean isNumeric(String strNum){
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe){
            return false;
        }
        return true;
    }
}
