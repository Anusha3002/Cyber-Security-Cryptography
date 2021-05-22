package io.project.cryptography.ceaser.cipher;

import java.util.*;

public class TestCaesarCipherProgram {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" Input the plaintext message : ");
		String plaintext = sc.nextLine();
		System.out.println(" Enter the value by which each"
				+ " character in the plaintext message gets shifted : ");
		int shift = sc.nextInt();
		String ciphertext = "";
		char alphabet;
		for (int i = 0; i < plaintext.length(); i++) {
			// Shift one character at a time
			alphabet = plaintext.charAt(i);

			// if alphabet lies between a and z
			if (alphabet >= 'a' && alphabet <= 'z') {
				// shift alphabet
				alphabet = (char) (alphabet + shift);
				// if shift alphabet greater than 'z'
				if (alphabet > 'z') {
					// reshift to starting position
					alphabet = (char) (alphabet + 'a' - 'z' - 1);
				}
				ciphertext = ciphertext + alphabet;
			}

			// if alphabet lies between 'A'and 'Z'
			else if (alphabet >= 'A' && alphabet <= 'Z') {
				// shift alphabet
				alphabet = (char) (alphabet + shift);

				// if shift alphabet greater than 'Z'
				if (alphabet > 'Z') {
					// reshift to starting position
					alphabet = (char) (alphabet + 'A' - 'Z' - 1);
				}
				ciphertext = ciphertext + alphabet;
			} 
			else if (alphabet >= '0' && alphabet <= '9') {
				// shift number
				alphabet = (char) (alphabet + shift);
				System.out.println(" alphabet "+ alphabet);
				// if shift alphabet greater than '9'
				if (alphabet > '9') {
					// reshift to starting position
					alphabet = (char) (alphabet + '0' - '9' - 1);
				} else if (alphabet < '0') {
					// reshift to end position
					alphabet = (char) (alphabet + '9' - '0' + 1);
					System.out.println();					
				}
				ciphertext = ciphertext + alphabet;
			}
			else {
				System.out.println(" alphabet 3 "+ alphabet);
				ciphertext = ciphertext + alphabet;
			}

		}
		System.out.println(" ciphertext : " + ciphertext);
	}
}
