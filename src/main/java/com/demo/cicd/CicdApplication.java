package com.demo.cicd;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.cicd.exception.InvalidEquationException;

/**
 * Main application class for the CICD demo.
 */
@SpringBootApplication
public class CicdApplication {
	/**
	 * This Logger, it... log things LOL
	 */
	private static final Logger MyLogger = LoggerFactory.getLogger(CicdApplication.class);

	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
		MyLogger.info("Inform a number:");

		int n1 = getNumber(scanner);

		MyLogger.info("Inform a number:");

		int n2 = getNumber(scanner);

		String equation = getEquation(scanner);
		int result = doEquation(equation, n1, n2);

		MyLogger.info("The result is {}", result);
	}

	public static int getNumber(final Scanner scanner) {
		return scanner.nextInt();
	}

	public static String getEquation(final Scanner scanner) {
		scanner.nextLine(); // Get the empty line
		MyLogger.info("Inform the desired calculation: 1-Addition 2-Subtraction 3-Multiplication 4-Division");
		return scanner.nextLine();
	}

	public static int doEquation(String equation, final int n1, final int n2) {
		int result;

		switch (equation) {
			case "1":
				result = n1 + n2;
				MyLogger.info("Returns the addition result");
				return result;
			case "2":
				result = n1 - n2;
				MyLogger.info("Returns the subtraction result");
				return result;
			case "3":
				result = n1 * n2;
				MyLogger.info("Returns the multiplication result");
				return result;
			case "4":
				result = n1 / n2;
				MyLogger.info("Returns the division result");
				return result;
			default:
				throw new InvalidEquationException("Please inform a valid equation");
		}
	}
}
