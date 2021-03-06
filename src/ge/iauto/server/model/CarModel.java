package ge.iauto.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@SuppressWarnings("serial")
@Entity
public class CarModel implements Serializable{
	
	private long id;
	
	private String name;
	
	private CarMake carmake;
	
	private List<Car> cars = new ArrayList<Car>();
	
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
	@OneToMany(mappedBy="carmodel",cascade = CascadeType.ALL)
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	

}
