package PracticePojo;

import java.util.List;

public class PojoCourses1 {
	
	private List<PojoWebAutomation1> webAutomation;
	private List<PojoApi1> api;
	private List<PojoMobile1> mobile;
	
	public void setWebAutomation(List<PojoWebAutomation1> webAutomation)	{
		this.webAutomation=webAutomation;
	}
	
	public List<PojoWebAutomation1> getWebAutomation()	{
		return webAutomation;
	}
	
	public List<PojoApi1> getAPI(){
		return api;
	}
	
	public void setAPI(List<PojoApi1> api) {
		this.api=api;
	}
	
	public List<PojoMobile1> getMobile(){
		return mobile;
	}
	
	public void setMobile(List<PojoMobile1> mobile) {
		this.mobile=mobile;
	}

	

}
	
