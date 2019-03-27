package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDaoImplementation implements UserDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
		
		sessionFactory.getCurrentSession().save(user);	
	}

	@Override
	public User getUser(String username, String password) {
		
		String hql = "FROM User WHERE username = :username AND password = :password";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("username", username);
        query.setString("password", password);
    	
        @SuppressWarnings("unchecked")
		List<User> list = query.list();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
	}

	@Override
	public User find(long userId) {
		
		try {
            User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
            return user;
        } catch (EmptyResultDataAccessException e) {
            //System.out.println(e);
            return null;
        }
	}

	@Override
	public boolean exists(String username) {
		
		return sessionFactory.getCurrentSession()
        		.createQuery("FROM User WHERE username = :username")
                .setString("username", username)
        		.list()
        		.size() == 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		String hql = "SELECT e FROM User e";
        return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public void deleteUser(long id) {
		
		User user = new User();
		user.setUserId(id);
		sessionFactory.getCurrentSession().delete(user);	
	}

	@Override
	public void updateUser(User e) {
		
		sessionFactory.getCurrentSession().update(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getEmployeeByName(String fName) {

		String hql = "SELECT e FROM User e WHERE e.username =:fName";
		return sessionFactory.getCurrentSession().createQuery(hql).setString("fName", fName).list();
	}

}
