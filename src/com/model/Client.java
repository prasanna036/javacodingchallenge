package com.model;

public class Client {

	private int clientId; 
	private String clientName; 
	private String contactInfo; 
	private int policyId;
	private String policyName;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int clientId, String clientName, String contactInfo, int policyId, String policyName) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.contactInfo = contactInfo;
		this.policyId = policyId;
		this.policyName = policyName;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", contactInfo=" + contactInfo
				+ ", policyId=" + policyId + ", policyName=" + policyName + "]";
	}
	
	
}
