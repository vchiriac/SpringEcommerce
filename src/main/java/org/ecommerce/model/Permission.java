package org.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(length = 1024)
    private String description;
    @ManyToMany(mappedBy = "permissions")
    private List<UserProfile> profiles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<UserProfile> profiles) {
        this.profiles = profiles;
    }


}