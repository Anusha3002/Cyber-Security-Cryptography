package io.project.cryptography.ceaser.cipher;

import java.util.*;

public class CaesarCipherProcessor {
	
	public String shiftText(int shift, String plaintext) {
		StringBuilder ciphertext = new StringBuilder();
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
				ciphertext.append(alphabet);
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
				ciphertext.append(alphabet);
			}
			else if (alphabet >= '0' && alphabet <= '9') {
				// shift number
				alphabet = (char) (alphabet + shift);
				// if shift alphabet greater than '9'
				if (alphabet > '9') {
					// reshift to starting position
					alphabet = (char) (alphabet + '0' - '9' - 1);
				} else if (alphabet < '0') {
					// reshift to end position
					alphabet = (char) (alphabet + '9' - '0' + 1);
				}
				ciphertext.append(alphabet);
			}
			else {
				//System.out.println(" alphabet "+ alphabet);
				ciphertext.append(alphabet);
			}

		}
		return ciphertext.toString();
	}
}
