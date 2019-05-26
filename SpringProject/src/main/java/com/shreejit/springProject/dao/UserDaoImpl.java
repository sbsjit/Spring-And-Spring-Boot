package com.shreejit.springProject.dao;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shreejit.springProject.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void userSignUp(User u) {
		Session sess = sessionFactory.getCurrentSession();
		sess.save(u);
	}

	@Override
	@Transactional
	public boolean userLogin(String un, String psw) {

		Session sess = sessionFactory.getCurrentSession();
		// Select all from user
		Criteria crt = sess.createCriteria(User.class);
		// where username is " " and password is " "
		crt.add(Restrictions.eq("username", un)).add(Restrictions.eq("password", psw));

		User u = (User) crt.uniqueResult();
		if (u != null) {
			return true;
		}

		return false;
	}

}
