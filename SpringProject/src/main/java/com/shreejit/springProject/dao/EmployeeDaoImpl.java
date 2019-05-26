package com.shreejit.springProject.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shreejit.springProject.model.Employee;

//To implement hibernate
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	//Its the id of bean; its the object of hibernate mentioned in  servlet-context.xml
	@Resource  //Binding
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional  //Helps in committing and roll-back features
	public void addEmployee(Employee e) {
		Session sess=sessionFactory.getCurrentSession();
		sess.save(e);
		
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		Session sess=sessionFactory.getCurrentSession();
		Employee emp=(Employee) sess.get(Employee.class, id);
		sess.delete(emp);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee e) {
		Session sess=sessionFactory.getCurrentSession();
		sess.update(e);
	}

	
	@Override
	@Transactional
	public Employee getById(int id) {
		Session sess=sessionFactory.getCurrentSession();
		Employee emp=(Employee) sess.get(Employee.class, id);
		return emp;
	}

	
	//Employee.class  ---->> selects the entire table
	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		Session sess=sessionFactory.getCurrentSession();
		Criteria crt=sess.createCriteria(Employee.class);
		return crt.list();
	}

}
