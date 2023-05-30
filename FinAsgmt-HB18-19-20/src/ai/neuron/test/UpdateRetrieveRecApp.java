package ai.neuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ai.neuron.model.Cricketer;
import ai.neuron.util.HibernateUtil;

// Problem/Solution::20
// To connect to MySQL database,insert data and retrieve the same from table
// Hibernate used to map the table to java object (here Cricketer)
// Model :Cricketer.class

public class UpdateRetrieveRecApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = 7;

		try {

			session = HibernateUtil.getSession();
			Cricketer cricketer = session.get(Cricketer.class, id);

			if (session != null)
				transaction = session.beginTransaction();
			// within a transacation the record can be updated
			if (transaction != null) {
				if (cricketer != null) {
					System.out.println("Record before Updation: "+cricketer);
					System.out.println();
					cricketer.setName("Hardik");
					cricketer.setTeamName("DDD");
					flag = true;
				} else
					System.out.println("Record not availablee for updation");

			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (flag) {
				transaction.commit();
				System.out.println("Object updated to database");

			} else {
				transaction.rollback();
				System.out.println("Object not updated to database");

			}
		}
		// Retreive the updated record and display the updation
		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				Cricketer cricObj = session.get(Cricketer.class, id);
				if (cricObj != null) {
					System.out.print("Retrieved Updated record::");
					System.out.println(cricObj);
				} else
					System.out.println("Record not found for given id :: " + id);
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
