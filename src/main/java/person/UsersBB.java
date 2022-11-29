package person;




import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;


import dao.PersonDAO;
import  dao.UsersDAO;
import entities.User;


@Named
@RequestScoped
public class UsersBB {
    private String login;

    @Inject
UsersDAO usersDAO;

    @Inject
    ExternalContext extcontext;

    @Inject
    Flash flash;

    @EJB
    PersonDAO personDAO;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<User> getFullList(){return usersDAO.getFullList();}

   /* public List<User> getList(){
        List<User> list = null;

        //1. Prepare search params
        Map<String,Object> searchParams = new HashMap<String, Object>();

        if (login != null && login.length() > 0){
            searchParams.put("login", login);
        }

        //2. Get list
        list = usersDAO.getList(searchParams);


        return list;
    }*/
}
