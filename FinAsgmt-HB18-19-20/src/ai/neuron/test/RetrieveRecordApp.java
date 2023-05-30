package ai.neuron.test;

// Problem/Solution::18
// To connect to MySQL database and rertrieve data from table
// Hibernate used to map the table to java object (here Cricketer)
// Model :Cricketer.class

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ai.neuron.model.*;
import ai.neuron.util.HibernateUtil;

public class RetrieveRecordApp {

	public static void main(String[] args) {

		Session session = null;
		int id = 1;

		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				Cricketer cricketer = session.get(Cricketer.class, id);
				if (cricketer != null)
					System.out.println(cricketer);
				else
					System.out.println("Record not foundd for given id :: " + id);//Student Object wont be created
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
