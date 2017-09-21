package com.JakeAnderson.DiscGolf.models;



import com.JakeAnderson.DiscGolf.models.forms.AbstractEntity;
import org.springframework.scheduling.Trigger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,11}", message = "Invalid username")
    private String username;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//    @OneToMany
//    @JoinColumn(name="user_id")
//    private List<Trigger> triggers = new ArrayList<>();

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = hashPassword(password);
    }
    public String getUsername() { return username; }

    private static String hashPassword(String password) { return encoder.encode(password);}

    public boolean isMatchingPassword(String password) {return encoder.matches(password, pwHash); }

}
