package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session saveSession = factory.getCurrentSession();
		
		try {
//			Creating new student object
			Student newStudent=new Student("Daffy","Duck","daffy@luv2code.com");
			
			// start a transaction
			saveSession.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(newStudent);
			saveSession.save(newStudent);	
			
			// commit transaction
			saveSession.getTransaction().commit();						
			System.out.println("Saved Student. Generated ID:"+newStudent.getId());
			
//			get a new session and start the transaction
			Session readSession=  factory.getCurrentSession();
			readSession.beginTransaction();
			
			System.out.println("Getting Student with ID:"+newStudent.getId());
//			Read student from the database
			Student myStudent =readSession.get(Student.class,newStudent.getId());
			System.out.println("Student retrieved: "+myStudent);
			// commit transaction
			readSession.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}