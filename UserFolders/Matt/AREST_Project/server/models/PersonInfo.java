package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@MappedSuperclass
public abstract class PersonInfo extends Model {

    @Id
    public Long id;
    @Required
    public String firstName;
    @Required
    public String lastName;
    @Required
    public String address;
    @Required
    public String phoneNumber;

}

