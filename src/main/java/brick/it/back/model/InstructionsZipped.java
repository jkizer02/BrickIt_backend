package brick.it.back.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="InstructionsZipped")
public class InstructionsZipped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private byte[] zippedInstructions; // Zipped instructions file	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getZippedInstructions() {
		return zippedInstructions;
	}
	
	public void setZippedInstructions(byte[] zippedInstructions) {
		this.zippedInstructions = zippedInstructions;
	}

}