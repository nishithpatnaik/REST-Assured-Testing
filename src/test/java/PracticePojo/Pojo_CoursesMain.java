package PracticePojo;


public class Pojo_CoursesMain 
{
	
	private String url;
	private String services;
	private String expertise;
	private PojoCourses1 courses;
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
	public void setCourses(PojoCourses1 courses)	{
		this.courses=courses;
	}
	public PojoCourses1 getCourses()	{
		return courses;
	}
	
	public void setInstructor(String instructor)	{
		this.instructor = instructor;
	}
	public String getInstructor()	{
		return instructor;
	}
	


	
	
}

