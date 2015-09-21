package dataBaseConnections;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dto.Rol;
import dto.User;
import utils.HibernateUtil;

public class UserConnections {

	public boolean validUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> u = session.createCriteria(User.class).list();
		for (int i = 0;i< u.size() ; i++){
			User actual = u.get(i);
			for (Rol s : actual.getRols()) {
			    System.out.println(s.getRol());
			}
			if ((actual.getUsername().equals(user.getUsername())) && actual.getPassword().equals(user.getPassword()))
				return true;
			
		}
		return false;
	}
	
	public Set<Rol> getUserRole(User user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> u = session.createCriteria(User.class).list();
		for (int i = 0;i< u.size() ; i++){
			User actual = u.get(i);
			if ((actual.getUsername().equals(user.getUsername())) && actual.getPassword().equals(user.getPassword()))
				return user.getRols();
		}
		return null;
	}

}
