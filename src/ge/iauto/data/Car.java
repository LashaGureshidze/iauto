package ge.iauto.data;

import java.awt.Image;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	
	private long id;
	
	private User user;
	
	private String category;
	
	private long mark;
	
	private long model;
	
	private String location;
	
	private String year;
	
	private String kilometer;
	
	private String doors;
	
	private String airbag;
	
	private boolean rent;
	
	private String gearbox;
	
	private String username;
	
	private boolean abs;
	
	private boolean window;
	
	private boolean climat;
	
	private boolean wheel;
	//ლუქი
	private boolean topwindow;
	
	private boolean computer;
	
	private boolean sequrity;
	
	private String price;
	
	private boolean ganbajebuli;
	
	private boolean exchange;
	
	private boolean saleonauction;
	
	private double engine;
	
	private String cylinder;
	
	private String actionwheel;
	
	private String fuel;
	
	private String color;
	
	private boolean rightsteeringwheel;
	
	private boolean turbo;
	
	private String telephone;
	
	private boolean parkcontrol;
	
	private boolean conditioner;
	
	private boolean leather;
	
	private boolean navigation;
	
	private boolean centrallock;
	
	private boolean savardzlisgatboba;
	
	private boolean hydraulics;
	
	private String bringyear;
	
	private String vincode;
	
	private String describtion;
	
	private ArrayList<Image> images;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getMark() {
		return mark;
	}

	public void setMark(long mark) {
		this.mark = mark;
	}

	public long getModel() {
		return model;
	}

	public void setModel(long model) {
		this.model = model;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getKilometer() {
		return kilometer;
	}

	public void setKilometer(String kilometer) {
		this.kilometer = kilometer;
	}

	public String getDoors() {
		return doors;
	}

	public void setDoors(String doors) {
		this.doors = doors;
	}

	public String getAirbag() {
		return airbag;
	}

	public void setAirbag(String airbag) {
		this.airbag = airbag;
	}

	public boolean isRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAbs() {
		return abs;
	}

	public void setAbs(boolean abs) {
		this.abs = abs;
	}

	public boolean isWindow() {
		return window;
	}

	public void setWindow(boolean window) {
		this.window = window;
	}

	public boolean isClimat() {
		return climat;
	}

	public void setClimat(boolean climat) {
		this.climat = climat;
	}

	public boolean isWheel() {
		return wheel;
	}

	public void setWheel(boolean wheel) {
		this.wheel = wheel;
	}

	public boolean isTopwindow() {
		return topwindow;
	}

	public void setTopwindow(boolean topwindow) {
		this.topwindow = topwindow;
	}

	public boolean isComputer() {
		return computer;
	}

	public void setComputer(boolean computer) {
		this.computer = computer;
	}

	public boolean isSequrity() {
		return sequrity;
	}

	public void setSequrity(boolean sequrity) {
		this.sequrity = sequrity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isGanbajebuli() {
		return ganbajebuli;
	}

	public void setGanbajebuli(boolean ganbajebuli) {
		this.ganbajebuli = ganbajebuli;
	}

	public boolean isExchange() {
		return exchange;
	}

	public void setExchange(boolean exchange) {
		this.exchange = exchange;
	}

	public boolean isSaleonauction() {
		return saleonauction;
	}

	public void setSaleonauction(boolean saleonauction) {
		this.saleonauction = saleonauction;
	}

	public double getEngine() {
		return engine;
	}

	public void setEngine(double engine) {
		this.engine = engine;
	}

	public String getCylinder() {
		return cylinder;
	}

	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	public String getActionwheel() {
		return actionwheel;
	}

	public void setActionwheel(String actionwheel) {
		this.actionwheel = actionwheel;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isRightsteeringwheel() {
		return rightsteeringwheel;
	}

	public void setRightsteeringwheel(boolean rightsteeringwheel) {
		this.rightsteeringwheel = rightsteeringwheel;
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isParkcontrol() {
		return parkcontrol;
	}

	public void setParkcontrol(boolean parkcontrol) {
		this.parkcontrol = parkcontrol;
	}

	public boolean isConditioner() {
		return conditioner;
	}

	public void setConditioner(boolean conditioner) {
		this.conditioner = conditioner;
	}

	public boolean isLeather() {
		return leather;
	}

	public void setLeather(boolean leather) {
		this.leather = leather;
	}

	public boolean isNavigation() {
		return navigation;
	}

	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}

	public boolean isCentrallock() {
		return centrallock;
	}

	public void setCentrallock(boolean centrallock) {
		this.centrallock = centrallock;
	}

	public boolean isSavardzlisgatboba() {
		return savardzlisgatboba;
	}

	public void setSavardzlisgatboba(boolean savardzlisgatboba) {
		this.savardzlisgatboba = savardzlisgatboba;
	}

	public boolean isHydraulics() {
		return hydraulics;
	}

	public void setHydraulics(boolean hydraulics) {
		this.hydraulics = hydraulics;
	}

	public String getBringyear() {
		return bringyear;
	}

	public void setBringyear(String bringyear) {
		this.bringyear = bringyear;
	}

	public String getVincode() {
		return vincode;
	}

	public void setVincode(String vincode) {
		this.vincode = vincode;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public ArrayList<Image> getImages() {
		return images;
	}

	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
