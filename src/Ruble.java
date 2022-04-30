import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;
import java.util.Stack;

class Ruble extends Currency {
	BigDecimal x;
	BigDecimal y;

	@Override
	public BigDecimal convert(String z) throws FileNotFoundException, IOException {
		Properties property = new Properties();
		property.load(new FileInputStream("resources/config.properties"));
		x = new BigDecimal(z);
		y = new BigDecimal(property.getProperty("rate"));
		return x.multiply(y);
	}

	@Override
	public String add(Stack<String> answer) {
		x = new BigDecimal(answer.pop().replace("p", ""));
		y = new BigDecimal(answer.pop().replace("p", ""));
		return answer.push(x.add(y).toString() + "p");
	}

	@Override
	public String subtract(Stack<String> answer) {
		x = new BigDecimal(answer.pop().replace("p", ""));
		y = new BigDecimal(answer.pop().replace("p", ""));
		return answer.push(y.subtract(x).toString() + "p");
	}

}