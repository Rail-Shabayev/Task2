import java.util.Stack;

public class Postfix {
	static Stack<String> make(String equation, Stack<String> pfix) {
		Stack<String> operator = new Stack<>();

		equation = equation.replaceAll("[(]", " ( ").replaceAll("[)]", " )");
		for (String element : equation.split(" ")) {

			if (element.equals("(")) {
				operator.push(element);

			} else if (element.equals(")")) {
				while (!operator.isEmpty() && operator.peek() != "(")
					pfix.push(operator.pop());

			} else if (element.equals("+") || element.equals("toDollars") || element.equals("toRubles") || element.equals("-")) {
				while (!operator.isEmpty() && order(element) <= order(operator.peek()))
					pfix.push(operator.pop());
				operator.push(element);

			} else {
				pfix.push(element);
			}
		}
		if(!operator.isEmpty()) 
			pfix.push(operator.pop());
		return pfix;
	}

	static int order(String op) {
		switch (op) {
		case "+":
		case "-":
			return 1;

		case "toDollars":
		case "toRubles":
			return 2;
		}
		return -1;
	}
}
