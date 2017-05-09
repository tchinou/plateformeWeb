package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import bean.Item;
import bean.OrderHeader;
import bean.OrderItem;
import bean.User;
import manager.UserManager;
import util.HibernateUtil;

public class Test_Main_Hibernate_User {

	public static void main(String[] args) {
		
			try{
				AnnotationConfiguration config = new AnnotationConfiguration();
				//config.addAnnotatedClass(Item.class);
				//config.addAnnotatedClass(OrderItem.class);
				config.addAnnotatedClass(User.class);
				config.addAnnotatedClass(OrderHeader.class);
				config.configure("hibernate.cfg.xml");
				new SchemaExport(config).create(true, true);
				SessionFactory factory = config.buildSessionFactory();
				// obtains the session
				Session session = factory.openSession();
				session.beginTransaction();
				User user = new User();
				user.setFirstName("lyes"); 
				user.setLastName("bouf"); 
				user.setLogin("tchinou"); 
				user.setPassword("123456");
				user.setEmail("lyesboufennara@outlook.fr"); 
				user.setId(1); 
				user.setIsAdmin(false);
				//user
				
				//orderHeader
				OrderHeader orderHead =  new OrderHeader();
				OrderHeader orderHead2 = new OrderHeader();
				
				orderHead.setUser(user);
				//orderHead2.setUser(user);
				//orderHead2.setId(2);
				orderHead.setId(1);
				orderHead.setDate(new Date());
				BigDecimal price=null;
				orderHead.setPrice(price);
				Set<OrderHeader> orders = new HashSet<OrderHeader>();
				orders.add(orderHead);
				orders.add(orderHead2);
				user.setOrderHeader(orders);
				session.save(user);
				//user.getOrderHeader().add(orderHead);
				//user.getOrderHeader().add(orderHead2);
				//session.save(user);
				//session.save(orderHead2);
				//session.save(orderHead);
				//session.persist(orderHead2);
				//session.getTransaction().commit();
				//session.close();
				//item	
				Item it1 = new Item();
				Item it2 = new Item();
				it1.setDescription("cafe");
				it2.setDescription("orange");
				session.save(orderHead);
				OrderItem orderItem = new OrderItem();
				orderItem.setOrderHeader(orderHead);
				session.save(it1);
				orderItem.setItem(it1);
				//orderItem
				
				
				
				Set<OrderItem> ordItm = new HashSet<OrderItem>();
				ordItm.add(orderItem);
				orderHead.setOrderItems(ordItm);
				it1.setOrdItems(ordItm);
				session.save(it1);
				//session.save(it1);
				//session.save(ordItm);
				//orderHead.setNombreItem(nbItem);
				//mapping objects on tables 
				//orderHead.getNombreItem().add(item);
				//orderHead.getOrderItems().add(orderItem);
				session.getTransaction().commit();

			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
			
		
		}
		

