package pl.system.Task.Dao;

import org.apache.catalina.User;
import pl.system.Task.Entity.Users;
import java.util.List;

public interface UsersDao {
    void save(Users users);
    Users findById(Integer id);
    Users findByName(String name);
    Users findBySurname(String surname);
    Users findByLogin(String login);
    List<User> findAll();
    void delete(Integer id);
}
