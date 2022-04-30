import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;
import java.util.Properties;
import java.util.Stack;

class Dollar extends Currency {
	BigDecimal x;
	BigDecimal y;

	@Override
	public BigDecimal convert(String z) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("resources/config.properties"));
		x = new BigDecimal(z);
		y = new BigDecimal(property.getProperty("rate"));
		return x.divide(y, 2, RoundingMode.HALF_UP);
	}

	@Override
	public String add(Stack<String> answer) {
		x = new BigDecimal(answer.pop().replace("$", ""));
		y = new BigDecimal(answer.pop().replace("$", ""));
		return answer.push("$" + x.add(y).toString());
	}

	@Override
	public String subtract(Stack<String> answer) {
		x = new BigDecimal(answer.pop().replace("$", ""));
		y = new BigDecimal(answer.pop().replace("$", ""));
		return answer.push("$" + y.subtract(x).toString());
	}
}
