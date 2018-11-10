package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		try {
			int studentId=4;
			// create read session
			Session getStudentSession= factory.getCurrentSession();
			
//			Get the Student
			getStudentSession.beginTransaction();			
//			Student myStudent= getStudentSession.get(Student.class, studentId);		
			
			getStudentSession.getTransaction().commit();
			
			// create delete session
//			Session deleteSession = factory.getCurrentSession();
			
			// start the deleting transaction
//			deleteSession.beginTransaction();			
			
			// delete the student object
//			System.out.println("Deleting the student:"+myStudent);
//			deleteSession.delete(myStudent);
			
			// commit transaction
//			deleteSession.getTransaction().commit();						
			
			
//			deleting student using query language
//			deleting student id=3
			Session deleteStudentQuerySession= factory.getCurrentSession();
			deleteStudentQuerySession.beginTransaction();
			deleteStudentQuerySession.createQuery("delete from Student where id=3").executeUpdate();
			deleteStudentQuerySession.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}