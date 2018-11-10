package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			//Create the Objects
//			Instructor instructor= new Instructor("Pedro","Henriques","pedro.pedro@gmail.com");
//			InstructorDetail instructorDetail= new InstructorDetail("youtube/Revtend", "Crossfit");
			
			Instructor instructor= new Instructor("Bruno","Henriques","bruno.bruno@gmail.com");
			InstructorDetail instructorDetail= new InstructorDetail("youtube/Revtend", "Crossfit");
			
			//Associate objects
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
						
			//Save the Instructor
			//This also saves instructorDetail because of CASCADE.ALL property
			System.out.println("Saving Instructor:"+ instructor);
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}