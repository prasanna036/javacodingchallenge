package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.PolicyNotFoundException;
import com.model.Client;
import com.util.DBUtil;

public class InsuranceServiceImpl implements IPolicyService {

	@Override
	public boolean createPolicy(String clientName,String contactInfo,int policyId,String policyName)throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into clients(clientName,contactInfo,policyId,policyName) values(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,clientName);
		pstmt.setString(2,contactInfo);
		pstmt.setInt(3,policyId);
		pstmt.setString(4,policyName);
		
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		return true;
	}

	@Override
	public Client getPolicy(int policyId) throws SQLException,PolicyNotFoundException {
		List<Client> list = new ArrayList<Client>();
		Connection conn = DBUtil.getDBConn();

		String sql = "select * from clients where policyId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,policyId);
		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			int clientId = rst.getInt("clientId");
			String clientName = rst.getString("clientName");
			String contactInfo= rst.getString("contactInfo");
			policyId=rst.getInt("policyId");
			String policyName=rst.getString("policyName");
			Client v = new Client(clientId,clientName,contactInfo,policyId,policyName);
			list.add(v);
			return v;
		}
		DBUtil.dbClose();
		throw new PolicyNotFoundException("Invalid Policy ID");
	}

	@Override
	public List<Client> getAllPolicies() throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<Client> list = new ArrayList<Client>();
		

		String sql = "select * from clients";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			int clientId = rst.getInt("clientId");
			String clientName = rst.getString("clientName");
			String contactInfo= rst.getString("contactInfo");
			int policyId=rst.getInt("policyId");
			String policyName=rst.getString("policyName");
			Client v=new Client();
			v.setClientId(clientId);
			v.setClientName(clientName );
			v.setContactInfo(contactInfo);
			v.setPolicyId(policyId);
			v.setPolicyName(policyName);
			list.add(v);
		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public boolean updatePolicy(String clientName,String contactInfo,int policyId,String policyName) throws SQLException, PolicyNotFoundException {
		Connection conn=DBUtil.getDBConn();
		String sql="update clients set clientname = ?,contactInfo =?,policyName=? where policyId =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,clientName);
		pstmt.setString(2,contactInfo);
		
		pstmt.setString(3,policyName);
		pstmt.setInt(4,policyId);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		throw new PolicyNotFoundException("Invalid Policy ID");
		
	}

	@Override
	public boolean deletePolicy(int policyId) throws SQLException, PolicyNotFoundException {
		Connection conn=DBUtil.getDBConn();
		String sql="DELETE FROM Clients WHERE policyId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,policyId);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		throw new PolicyNotFoundException("Invalid Policy ID");
	}

}
