package ge.iauto.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@SuppressWarnings("serial")
@Entity
public class CarModel implements Serializable{
	
	private long id;
	
	private String name;
	
	private CarMake carmake;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne()
	public CarMake getCarmake() {
		return carmake;
	}

	public void setCarmake(CarMake carmake) {
		this.carmake = carmake;
	}
	

}
