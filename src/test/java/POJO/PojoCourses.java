package POJO;
import java.util.List;

public class PojoCourses {
	private List<PojoWebAutomation> webAutomation;
	private List<PojoAPI> api;
	private List<PojoMobile> mobile;
	
	public void setWebAutomation(List<PojoWebAutomation> webAutomation)	{
		this.webAutomation=webAutomation;
	}
	
	public List<PojoWebAutomation> getWebAutomation()	{
		return webAutomation;
	}
	
	public List<PojoAPI> getAPI(){
		return api;
	}
	
	public void setAPI(List<PojoAPI> api) {
		this.api=api;
	}
	
	public List<PojoMobile> getMobile(){
		return mobile;
	}
	
	public void setMobile(List<PojoMobile> mobile) {
		this.mobile=mobile;
	}

}
