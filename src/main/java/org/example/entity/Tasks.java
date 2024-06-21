package org.example.entity;





import jakarta.persistence.*;

import java.time.LocalDateTime;



@Entity
@Table
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdateDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;

    public Tasks() {
    }

    public Tasks(String name, LocalDateTime creationDate, LocalDateTime lastUpdateDate, String description, Status status, Users users) {
        this.name = name;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.description = description;
        this.status = status;
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
