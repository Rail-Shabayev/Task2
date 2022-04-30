import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public enum Operator {
	ADD {
		@Override
		public void action(Stack<String> answer) { 
			Ruble r = new Ruble();
			Dollar d = new Dollar();
			if (answer.peek().contains("p")) {
				r.add(answer);
				
			} else if (answer.peek().contains("$")) {
				d.add(answer);
			} 			
		}
	}, SUBTRACT {
		@Override
		public  void action(Stack<String> answer) {
			Ruble r = new Ruble();
			Dollar d = new Dollar();
			if (answer.peek().contains("p")) {
				r.subtract(answer);
				
			} else if (answer.peek().contains("$")) {
				d.subtract(answer);

			}
		}
	}, TORUBLES {
		@Override
		public  void action(Stack<String> answer) throws FileNotFoundException, IOException{
			String x = (answer.pop()).replace("$", "");
			Ruble r = new Ruble();
			answer.push((r.convert(x).toString()) + "p");
		}
	}, TODOLLARS {
		@Override
		public  void action(Stack<String> answer) throws FileNotFoundException, IOException {
			String x = (answer.pop()).replace("p", "");
			Dollar d = new Dollar();
			answer.push("$" + (d.convert(x).toString()));
		}
	};
	public abstract void action(Stack<String> answer) throws FileNotFoundException, IOException ;
}

