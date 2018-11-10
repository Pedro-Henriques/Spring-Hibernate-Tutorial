package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class EmployeeDemo {

	private static SessionFactory factory= new Configuration().
			configure("hibernate.cfg.xml").
			addAnnotatedClass(Employee.class).
			buildSessionFactory();
	
	public static void main(String[] args) {
		
		Employee newEmployee= new Employee("Joana","Silva","Bial");
		
//		Saving Employee
		System.out.println("Saving Employee:"+ newEmployee);
		saveEmployee(newEmployee);
		System.out.println("Save Employee:"+ newEmployee+" completed");
		
//		Retrieve Employee by ID
		int employeeID=3;
		Employee retrievedEmployee=retrieveEmployee(employeeID);
		System.out.println("Retrieve Employee:"+ retrievedEmployee+" completed");
		
//		Retrieve Employees by Company ID
		String company="Retail Consult";
		List<Employee> employeesByCompanyID=retrieveEmployeesByCompanyID(company);
		System.out.println("Retrieved:"+employeesByCompanyID.size()+" Employees who work for "+company);
		
//		Delete Employee using Id
		System.out.println("Deleting Employee:"+ newEmployee);
		deleteEmployeeByID(retrievedEmployee);
	}

	private static void deleteEmployeeByID(Employee retrievedEmployee) {
		Session deleteEmployeeSession= factory.getCurrentSession();
		
		deleteEmployeeSession.beginTransaction();
		deleteEmployeeSession.delete(retrievedEmployee);
		deleteEmployeeSession.getTransaction().commit();
	}

	private static List<Employee> retrieveEmployeesByCompanyID(String company)
	{
		Session retrieveEmployeeByCompanySession= factory.getCurrentSession();
		retrieveEmployeeByCompanySession.beginTransaction();
		List<Employee> retrievedEmployees=retrieveEmployeeByCompanySession.
				createQuery("from Employee e where e.company='"+company+"'").getResultList();
		retrieveEmployeeByCompanySession.getTransaction().commit();
		
		return retrievedEmployees;
	}

	private static Employee retrieveEmployee(int employeeID) {
		Session retrieveEmployeeSession= factory.getCurrentSession();
		retrieveEmployeeSession.beginTransaction();
		Employee retrievedEmployee=retrieveEmployeeSession.get(Employee.class,employeeID);
		retrieveEmployeeSession.getTransaction().commit();
		
		return retrievedEmployee;
	}

	private static void saveEmployee(Employee newEmployee) {
		Session saveEmployeeSession= factory.getCurrentSession();
		
		saveEmployeeSession.beginTransaction();
		saveEmployeeSession.save(newEmployee);
		saveEmployeeSession.getTransaction().commit();
	}
	
	

}
