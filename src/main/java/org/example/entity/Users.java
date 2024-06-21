package org.example.entity;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor

public class Users {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "users")
    private List<Tasks> tasks;

    public Users() {}

    public Users(String username, String password, Roles role, List<Tasks> tasks) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.tasks = tasks;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", tasks=" + tasks +
                ", password='" + password + '\'' +
                '}';
    }
}
