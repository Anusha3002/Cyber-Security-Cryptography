/**
 * 
 */
package io.project.cryptography.web.dto;

/**
 * @author vipink
 *
 */
public class CaeserCipherDto {

	private String text;
	
	private Integer shift;
	
	private String title;
	
	private Long id;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CaeserCipherDto [text=" + text + ", shift=" + shift
				+ ", title=" + title + "]";
	}
	
	
}
