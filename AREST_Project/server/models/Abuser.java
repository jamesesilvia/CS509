package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Abuser extends PersonInfo {

    @Required
    public String relationshipToVictim;
    @Required
    public String social;
    @Required
    public String dob;

}

