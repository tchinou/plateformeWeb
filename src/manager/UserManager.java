package manager;

import org.hibernate.Session;
import org.hibernate.property.Getter;

import bean.User;
import util.HibernateUtil;

public class UserManager {
	
	public void ajoutUser(String firstName, String lastName, String email, String login,String password, boolean isAdmin){
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setEmail(email);
		u.setLogin(login);
		u.setPassword(password);
		u.setIsAdmin(isAdmin);
		session.save(u);
		session.getTransaction().commit();
	}
	public void suppressionUser(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User u = (User) session.load(User.class, id);
		session.delete(u);
		session.getTransaction().commit();
	}

}
