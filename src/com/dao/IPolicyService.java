package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.PolicyNotFoundException;
import com.model.*;
public interface IPolicyService {
	 public boolean createPolicy(String clientName,String contactInfo,int policyId,String policyName)throws SQLException;
	 Client getPolicy(int policyId)throws SQLException, PolicyNotFoundException;
	 public List<Client> getAllPolicies()throws SQLException;
	 public boolean updatePolicy(String clientName,String contactInfo,int policyId,String policyName)throws SQLException, PolicyNotFoundException;
	 public boolean deletePolicy(int policyId)throws SQLException, PolicyNotFoundException;
}
