/**
 * 
 */
package io.project.cryptography.persistence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author anusha
 *
 */
@Entity
@Table(name = "caeser_cipher")
public class CaeserCipher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title;
    
    private String text;
    
    private String caesertext; 
    
    private Integer shift;
    
    private Date created;
    
    private Date modified;
   
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCaesertext() {
		return caesertext;
	}

	public void setCaesertext(String caesertext) {
		this.caesertext = caesertext;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CaeserCipher [id=" + id + ", title=" + title + ", text=" + text
				+ ", caesertext=" + caesertext + ", shift=" + shift
				+ ", created=" + created + ", modified=" + modified + ", user="
				+ user + "]";
	}
    
    
}
