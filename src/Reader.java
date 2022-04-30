import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public class Reader {

	static void read(Stack<String> pfix) throws FileNotFoundException, IOException {
		Stack<String> answer = new Stack<>();
		Operator operator;
		try {
			for (String element : pfix) {
				if (element.equals("toRubles")) {
					operator = Operator.TORUBLES;
					operator.action(answer);
					
				} else if (element.equals("toDollars")) {
					operator = Operator.TODOLLARS;
					operator.action(answer);
					
				} else if (element.equals("+")) {
					operator = Operator.ADD;
					operator.action(answer);
					
				} else if (element.equals("-")) {
					operator = Operator.SUBTRACT;
					operator.action(answer);
					
				} else if (element.equals("(")) {
				} else {
					answer.push(element);
				}
			}			
			System.out.println(answer);
		} catch(NumberFormatException e) {
			System.out.println("Выражение введено неправильно!");
		}
	}
}
