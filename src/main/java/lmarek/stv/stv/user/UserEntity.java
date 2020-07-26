package lmarek.stv.stv.user;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", indexes = @Index(name = "find_by_email", columnList = "email", unique = true))
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    private List<PrivilegeEntity> privileges;

}
