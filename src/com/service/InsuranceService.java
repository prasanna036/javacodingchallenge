package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.InsuranceServiceImpl;
import com.exception.PolicyNotFoundException;
import com.model.Client;

public class InsuranceService {
	InsuranceServiceImpl insuranceService=new InsuranceServiceImpl();
	public boolean createPolicy(String clientName,String contactInfo,int policyId,String policyName)throws SQLException{
		return insuranceService.createPolicy(clientName,contactInfo,policyId,policyName);
	}
	public Client getPolicy(int policyId) throws SQLException,PolicyNotFoundException {
		return insuranceService.getPolicy(policyId);
	}
	public List<Client> getAllPolicies() throws SQLException {
		return insuranceService.getAllPolicies();
	}
	public boolean updatePolicy(String clientName,String contactInfo,int policyId,String policyName) throws SQLException, PolicyNotFoundException {
		
		return insuranceService.updatePolicy(clientName, contactInfo, policyId, policyName);
	}
	public boolean deletePolicy(int policyId) throws SQLException, PolicyNotFoundException {
		return insuranceService.deletePolicy(policyId);
	}
}
