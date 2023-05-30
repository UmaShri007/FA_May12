package ai.neuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import ai.neuron.model.Cricketer;
import ai.neuron.util.HibernateUtil;

// Problem/Solution::19
// To connect to MySQL database,insert data and retrieve the same from table
// Hibernate used to map the table to java object (here Cricketer)
// Model :Cricketer.class

public class InsertRetreiveRecApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
	
		//save the cricketer data to database using save().
		
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null) {
				transaction = session.beginTransaction();
				
			if(transaction!=null) {
				
				Cricketer cricketer = new Cricketer();
				
				cricketer.setName("Pandey");
				cricketer.setAge(36);
				cricketer.setTeamName("GT");
				
//				Cricketer cricketer2 = new Cricketer();
//				cricketer.setName("Virat");
//				cricketer.setAge(35);
//				cricketer.setTeamName("RCB");
				
				id = (Integer)session.save(cricketer);
//				session.save(cricketer2);
				flag=true;
			}
			}		
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Objects saved into database");
			}else {
				transaction.rollback();
				System.out.println("Objects not saved to database");
			}
		}
		
		//Retrieve the cricketer data from database using get().
			try {
				
				session=HibernateUtil.getSession();
	//			Integer crickId = 2;
				
				if(session!=null) {
			Cricketer cricketer = session.get(Cricketer.class,id);
				if(cricketer!=null) {
				System.out.print("Retrieved record::");
				System.out.println(cricketer);
			}
				else
					System.out.println("Record not foundd for given id :: " + id);
			}
		}catch(HibernateException he) {
			he.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
