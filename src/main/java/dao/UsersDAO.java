package dao;

import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class UsersDAO {

    // Dependency injection (no setter method is needed)
    @PersistenceContext
    protected EntityManager em;

    public void create(User user) {
        em.persist(user);
    }

    public User merge(User user) {
        return em.merge(user);
    }

    public void remove(User user) {
        em.remove(em.merge(user));
    }

    public User find(Object id) {
        return em.find(User.class, id);
    }


    public User getUserFromDatabase(String login, String pass) {

        User u = null;

        if (login.equals("user1") && pass.equals("password")) {
            u = new User();
            u.setLogin(login);
            u.setPassword(pass);
            u.setName("Jan");

        }

        if (login.equals("user2") && pass.equals("password")) {
            u = new User();
            u.setLogin(login);
            u.setPassword(pass);
            u.setName("Anna");
        }
        if (login.equals("user3") && pass.equals("password")) {
            u = new User();
            u.setLogin(login);
            u.setPassword(pass);
            u.setName("Michał");

        }
        return u;
    }
    public List<User> getFullList() {
        List<User> list = null;

        Query query = em.createQuery("select u from User u");

        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

/*
    public List<User> getList(Map<String, Object> searchParams) {
        List<User> list = null;

        // 1. Build query string with parameters
        String select = "select u ";
        String from = "from User u ";
        String where = "";
        String orderby = "order by u.login asc, u.name";

        // search for login
        String login= (String) searchParams.get("login");
        if (login != null) {
            if (where.isEmpty()) {
                where = "where ";
            } else {
                where += "and ";
            }
            where += "u.login like :login ";
        }

        // ... other parameters ...

        // 2. Create query object
        Query query = em.createQuery(select + from + where + orderby);

        // 3. Set configured parameters
        if (login != null) {
            query.setParameter("login", login+"%");
        }

        // ... other parameters ...

        // 4. Execute query and retrieve list of Person objects
        try {
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
*/

}
