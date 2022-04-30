import java.io.*;
import java.util.*;

public class Task {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String i = "Введите выражение, ставя пробелы между функциями.";
		System.out.println(i);
		System.out.println("Например: toDollars(737p + toRubles($85.4))");
		Scanner scanner = new Scanner(System.in);
		String equation = scanner.nextLine();
		scanner.close();
		Stack<String> pfix = new Stack<>();
		Postfix.make(equation, pfix);
		Reader.read(pfix);
	}
}