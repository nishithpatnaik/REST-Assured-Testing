package POJO;

public class DeSerializeRoot {
	
	private String url;
	private String services;
	private String expertise;
	private PojoCourses courses;
	private String instructor;
	private String linkedIn;
	
	
	public String getUrl() 	{
		return url;
	}
	public void setUrl(String url) 	{
		this.url = url;
	}
	
	public void setServices(String services)	{
		this.services = services;
	}
	
	public String getServices()	{
		return services;
	}
	
	public void setExpertise(String expertise)	{
		this.expertise=expertise;
	}
	
	public String getExpertise()	{
		return expertise;
	}
	
	public void setLinkedIn(String linkedIn)	{
		this.linkedIn=linkedIn;
	}
	
	public String getLinkedIn()	{
		return linkedIn;
	}
	public void setCourses(PojoCourses courses)	{
		this.courses=courses;
	}
	public PojoCourses getCourses()	{
		return courses;
	}
	
	public void setInstructor(String instructor)	{
		this.instructor = instructor;
	}
	public String getInstructor()	{
		return instructor;
	}
	

	
	
}
