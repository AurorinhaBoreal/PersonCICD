package com.demo.cicd;

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
	private static final Logger MyLogger = LoggerFactory.getLogger(CicdApplication.class);

	public static void main(final String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyLogger.info("Inform a number:");

		int n1 = getNumber(scanner);

		MyLogger.info("Inform a number:");

		int n2 = getNumber(scanner);

		int result = doEquation(scanner, n1, n2);

		MyLogger.info("The result is {}", result);
	}

	public static int getNumber(final Scanner scanner) {
		return scanner.nextInt();
	}

	public static int doEquation(final Scanner scanner, final int n1, final int n2) {
		MyLogger.info("Inform the desired calculation: 1-Addition 2-Subtraction 3-Multiplication 4-Division");
		scanner.nextLine(); // Get the empty line
		String e = scanner.nextLine();
		int result;

		switch (e) {
			case "1":
				result = n1 + n2;
				return result;
			case "2":
				result = n1 - n2;
				return result;
			case "3":
				result = n1 * n2;
				return result;
			case "4":
				result = n1 / n2;
				return result;
			default:
				throw new InvalidEquationException("Please inform a valid equation");
		}
	}
}
