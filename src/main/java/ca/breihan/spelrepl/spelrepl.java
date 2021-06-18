package ca.breihan.spelrepl;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class spelrepl {
	public static void main(String[] args) {
		String code = "";
		System.out.println("Spring Expression Language (SpEL) REPL\nType quit to exit.\n");
		ExpressionParser parser = new SpelExpressionParser();
		Scanner sc = new Scanner(System.in);
		while (code != "quit") {
			try {
				System.out.print("SpEL> ");
				code = sc.nextLine();
				if(code.equals("quit") || code.equals("exit") )
					System.exit(0);
				Expression exp = parser.parseExpression(code);
				System.out.println(String.valueOf(exp.getValue()));
			}
			catch (NoSuchElementException e) {
				System.exit(0);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}
