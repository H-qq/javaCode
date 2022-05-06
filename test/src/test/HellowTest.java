package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class HellowTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//
		for (int i = 0; i <= Math.sqrt(n)+1; i++) {
			if (i*i>n) {
				System.out.println(i-1);
				break;
			}else if (i*i==n) {
				System.out.println(i);
				break;
			}
		}	
	}
}
