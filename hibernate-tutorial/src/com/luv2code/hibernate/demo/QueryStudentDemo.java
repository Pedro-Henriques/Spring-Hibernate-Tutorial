package com.luv2code.hibernate.demo;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
					
			// start a transaction
			session.beginTransaction();
			
			//Query database for Students
			List<Student> students= new ArrayList<Student>();
			students=session.
					createQuery("from Student")
					.getResultList();
			
			
			//Display students
			displayStudents(students);
			
			//Query students for lastname="Doe"
			students=session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			System.out.println("\nStudentes with last name = Duck");
			displayStudents(students);
			
			
			//Query students for lastname="Doe" or fistname=daffy
			students=session.createQuery("from Student s where"+
					" s.lastName='Doe' or s.firstName='Daffy'").getResultList();
			System.out.println("\nStudentes with last name = Duck or first name=Daffy");
			displayStudents(students);
			
			//Query students where email like luv2code.com
			students=session.createQuery("from Student s where"+
					" s.emailAddress LIKE '%luv2code.com'").getResultList();
			System.out.println("\nStudentes where email like luv2code.com");
			displayStudents(students);
			
			
			//Query students where email like gmail.com
			students=session.createQuery("from Student s where"+
					" s.emailAddress LIKE '%gmail.com'").getResultList();
			System.out.println("\nStudentes where email like gmail.com");
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student currentStudent:students)
		{
			System.out.println(currentStudent);
		}
	}

}