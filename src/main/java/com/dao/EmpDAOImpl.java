package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Emp;
/**
 *
 * @author admin
 */
@Repository
public class EmpDAOImpl implements EmpDAO {
	

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addEmp(Emp empdata) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(empdata);
		          System.out.println("Emp saved successfully, Emp Details="+empdata);
	}

	@Override
	public void updateEmp(Emp empdata) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(empdata);
		 System.out.println("Emp updated successfully, Emp Details="+empdata);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> listEmp() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Emp> EmpsList = session.createQuery("from Emp").list();
		for(Emp empdata : EmpsList){
			 System.out.println("Emp List::"+empdata);
		}
		return EmpsList;
	}

	@Override
	public Emp getEmpById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Emp empdata = (Emp) session.load(Emp.class, new Integer(id));
		 System.out.println("Emp loaded successfully, Emp details="+empdata);
		return empdata;
	}

	@Override
	public void removeEmp(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Emp empdata = (Emp) session.load(Emp.class, new Integer(id));
		if(null != empdata){
			session.delete(empdata);
		}
		 System.out.println("Emp deleted successfully, Emp details="+empdata);
	}

}
