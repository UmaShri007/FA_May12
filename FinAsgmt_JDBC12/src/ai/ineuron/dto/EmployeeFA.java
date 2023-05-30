package ai.ineuron.dto;

import java.io.Serializable;

public class EmployeeFA implements Serializable {

	public static final long serialVersionId= 1L;
	private int eId;
	private String eName;
	private String eMobile;
	private String eCity;
	
	
	public EmployeeFA() {
		super();
		
	}
	public EmployeeFA(String eName, String eMobile, String eCity) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eMobile = eMobile;
		this.eCity = eCity;
	}
	public EmployeeFA(int eId, String eName, String eMobile, String eCity) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eMobile = eMobile;
		this.eCity = eCity;
	}


	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteMobile() {
		return eMobile;
	}
	public void seteMobile(String eMobile) {
		this.eMobile = eMobile;
	}
	public String geteCity() {
		return eCity;
	}
	public void seteCity(String eCity) {
		this.eCity = eCity;
	}
	@Override
	public String toString() {
		return "EmployeeFA [eId=" + eId + ", eName=" + eName + ", eMobile=" + eMobile + ", eCity=" + eCity + "]";
	}
	
	
}
