package models;

import java.util.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Guardian extends PersonInfo {

    @Required
    public String relationshipToVictim;

}

