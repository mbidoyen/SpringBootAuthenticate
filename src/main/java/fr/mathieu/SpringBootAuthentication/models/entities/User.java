package fr.mathieu.SpringBootAuthentication.models.entities;

import java.util.Set;
import java.util.UUID;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_USER_USR", schema = "authentication")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "USR_ID", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "USR_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "USR_PASSWORD", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT", nullable = false)
    private Date updatedAt;

    @Builder.Default
    @ManyToMany(mappedBy = "users")
    private Set<Authority> authorities = new HashSet<>();

    @Column(name = "USR_ENABLED", nullable = false)
    private Boolean enabled;

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
        authority.getUsers().add(this);
    }

    public void removeAuthorities(Authority authority) {
        this.authorities.remove(authority);
        authority.getUsers().remove(this);
    }

    @Override
    public String toString() {
        return "UserEntity{" + "\n" +
                "uuid=" + this.id + "\n" +
                "email=" + this.email + "\n" +
                "authorities=" + this.authorities + "\n" +
                "enabled=" + this.enabled + "\n" +
                "createdAt=" + this.createdAt + "\n" +
                "updatedAt=" + this.updatedAt + "\n" +
                "}";
    }
}
