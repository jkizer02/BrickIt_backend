package brick.it.back.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Instructions")
public class Instructions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String description;
	private String title;
	
	private Long instructpdfzipid; // PDF zip file containing the instructions 
	
	@Lob
    private byte[] iconImage; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getInstructpdfzipid() {
		return instructpdfzipid;
	}

	public void setInstructpdfzipid(Long instructpdfzipid) {
		this.instructpdfzipid = instructpdfzipid;
	}
	
	public byte[] getIconImage() {
		return iconImage;
	}
	
	public void setIconImage(byte[] iconImage) {
		this.iconImage = iconImage;
	}
	
	
}
