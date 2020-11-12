package pl.system.Task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.system.Task.DaoImpl.UsersDaoImpl;
import pl.system.Task.Entity.Users;
import pl.system.Task.Utils.HibernateUtils;

@SpringBootApplication

public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
		UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
		Users user1 = new Users("Marcin", "Młynarski","umpalumpas");
		Users user2 = new Users("aga", "spbpl","xoxox");
//		usersDaoImpl.save(user1);
//		usersDaoImpl.save(user2);



		System.out.println(usersDaoImpl.findAll());


	}


}
