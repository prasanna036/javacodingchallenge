package com.controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.PolicyNotFoundException;
import com.model.*;
import com.service.*;
public class InsuranceController {
  public static void main(String[] args) throws PolicyNotFoundException {
	InsuranceService insuranceService = new InsuranceService();
	List<Client> list = new ArrayList<Client>();
	Scanner sc=new Scanner(System.in);
	while (true) {
		System.out.println("*****************INSURANCE OPS ****************");
		System.out.println("Press 1 for Create Policy");
		System.out.println("Press 2 for GetPolicy");
		System.out.println("Press 3 for GetAllPolicies");
		System.out.println("Press 4 for UpdatePolicy");
		System.out.println("Press 5 for DeletePolicy");
		System.out.println("Press 0 to Exit");
		
		System.out.println("********************************************");
		int input = sc.nextInt();
		if (input == 0) {
			System.out.println("Thank You");
			break;
		}

		switch (input) {
		case 1:
			System.out.println("Enter Your Name ");
			sc.nextLine();
			String clientName=sc.nextLine();
			System.out.println("Enter Your contactInfo ");
			String contactInfo=sc.nextLine();
			System.out.println("Enter Your policyId ");
			int policyId=sc.nextInt();
			System.out.println("Enter Your policyName ");
			String policyName=sc.nextLine();
			try {
				insuranceService.createPolicy(clientName,contactInfo,policyId,policyName);
				System.out.println("Policy Created Successfully");

			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Enter Your Policy ID ");
			int pid=sc.nextInt();
			try {
				Client v =insuranceService.getPolicy(pid);
				System.out.println(v.getClientId() + "  " + v.getClientName() + "  " + v.getContactInfo()+"  "+v.getPolicyId()+" "+v.getPolicyName());

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			
			try {
				list=insuranceService.getAllPolicies();
				for(Client c:list) {
					System.out.println(c.getClientId() + "  " + c.getClientName() + "  " + c.getContactInfo()+"  "+c.getPolicyId()+" "+c.getPolicyName());
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			break;
			
		case 4:
			System.out.println("Enter Your Name ");
			sc.nextLine();
			clientName=sc.nextLine();
			System.out.println("Enter Your contactInfo ");
			contactInfo=sc.nextLine();
			System.out.println("Enter Your policyId ");
			policyId=sc.nextInt();
			System.out.println("Enter Your policyName ");
		    policyName=sc.nextLine();
		    try {
				insuranceService.updatePolicy(clientName,contactInfo,policyId,policyName);
				System.out.println("Policy Updated Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			break;
		
		case 5:
			System.out.println("Enter Your Policy Id");
			pid=sc.nextInt();
			try {
				insuranceService.deletePolicy(pid);
				System.out.println("Policy Deleted Successfully");

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			break;
		
		}
	}
	
}
}
	
	