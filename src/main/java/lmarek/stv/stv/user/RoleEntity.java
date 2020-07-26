package lmarek.stv.stv.user;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", indexes = @Index(name = "find_role_by_name", columnList = "name", unique = true))
@Data
public class RoleEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<PrivilegeEntity> privileges;

}
