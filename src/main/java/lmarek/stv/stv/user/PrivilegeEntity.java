package lmarek.stv.stv.user;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "privileges", indexes = @Index(name = "find_privilege_by_name", columnList = "name", unique = true))
@Data
public class PrivilegeEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<RoleEntity> roles;

}
