package io.project.cryptography.web.controller;

public class CsesarCipherInput {

	private int shift;
	private String text;
	public int getShift() {
		return shift;
	}
	public void setShift(int shift) {
		this.shift = shift;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "CsesarCipherInput [shift=" + shift + ", text=" + text + "]";
	}
}
