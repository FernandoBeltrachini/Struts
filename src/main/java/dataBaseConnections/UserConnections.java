package dataBaseConnections;

import java.util.List;

import org.hibernate.Session;

import dto.User;
import utils.HibernateUtil;

public class UserConnections {

	public boolean validUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> u = session.createCriteria(User.class).list();
		for (int i = 0;i< u.size() ; i++){
			User actual = u.get(i);
			if ((actual.getUserName().equals(user.getUserName())) && actual.getPassword().equals(user.getPassword()))
				return true;
			
		}
		return false;
	}

}
