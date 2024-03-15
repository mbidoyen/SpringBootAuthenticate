package fr.mathieu.SpringBootAuthentication.models.entities;

import java.util.Set;
import java.util.UUID;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_ROLE_RLE", schema = "authentication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "RLE_ID", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "RLE_ROLENAME", nullable = false)
    private String rolename;

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "TA_ROLE_USER_RLU", schema = "authentication", joinColumns = @JoinColumn(name = "RLE_ID"), inverseJoinColumns = @JoinColumn(name = "USR_ID"))
    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return rolename;
    }

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT", nullable = false)
    private Date updatedAt;

    @Override
    public String toString() {
        return "role={" + "\n" +
                "id=" + this.id + "\n" +
                "rolename=" + this.rolename + "\n" +
                "createdAt=" + this.createdAt + "\n" +
                "updatedAt=" + this.updatedAt + "\n" +
                "}";
    }

}
