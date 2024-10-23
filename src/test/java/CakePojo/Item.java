package CakePojo;

import java.util.List;

public class Item {
	
	private String id;
	private String type;
	private String name;
	private Batters batters;
	private Double ppu;
	private List<Topping> topping;
	
	public void setBatters(Batters batters)
	{
		this.batters = batters;
	}
	
	public Batters getBatters()
	{
		return batters;
	}
	
	public void setTopping(List<Topping> topping)
	{
		this.topping = topping;
	}
	
	public List<Topping> getTopping()
	{
		return topping;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPpu() {
		return ppu;
	}

	public void setPpu(Double ppu) {
		this.ppu = ppu;
	}
	

}
