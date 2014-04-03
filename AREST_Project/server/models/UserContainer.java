package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class UserContainer extends Model {

    @Id
    public Long id;

    @Required
    public String userName;

    @Required
    public String firstName;

    @Required
    public String lastName;

    @Required
    public String email;

    @Required
    public boolean isSupervisor;

    public Long password;
    public int salt;

    public static Finder<Long,UserContainer> find = new Finder(Long.class, UserContainer.class);

    public static List<UserContainer> all() {
        return find.all();
    }

    public static void create(UserContainer user) {
        user.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

    public static UserContainer get(Long id) {
        return find.ref(id);
    }

}
