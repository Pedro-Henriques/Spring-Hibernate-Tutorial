package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// Get instructor by ID
			int theID = 8;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);

			// Print Instructor that came with InstructorDetail query
			System.out.println("Printing Instructor Detail:" + instructorDetail);
			System.out.println("Printing Instructor:" + instructorDetail.getInstructor());

			//Remove the associated object reference
			//Break bidirectional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			// Delete the Instructor Detail
			// This will also delete Instructor because of Cascade property
			System.out.println("Deleting Instructor Detail:" + instructorDetail);
			session.delete(instructorDetail);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			// Handle connection leak
			session.close();
			factory.close();
		}
	}

}