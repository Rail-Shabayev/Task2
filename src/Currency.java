import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Stack;

abstract class Currency {

	public abstract BigDecimal convert(String x) throws FileNotFoundException, IOException;
	public abstract String add(Stack<String> answer);
	public abstract String subtract(Stack<String> answer);
}
