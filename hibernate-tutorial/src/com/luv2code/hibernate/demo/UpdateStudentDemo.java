package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId=1;
			// start a transaction
			session.beginTransaction();
			Student myStudent= session.get(Student.class, studentId);
			
			System.out.println("Updating student:" + myStudent);
			
			myStudent.setFirstName("Bruno");
			
			// commit transaction
			session.getTransaction().commit();
			
			//Bulk update session
			Session bulkUpdateSession= factory.getCurrentSession();			
			bulkUpdateSession.beginTransaction();
			
//			Update email for all students
			System.out.println("Updating email for all students");
			bulkUpdateSession.createQuery("update Student s set s.email='foo@gmail.com'").executeUpdate();			
			bulkUpdateSession.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}