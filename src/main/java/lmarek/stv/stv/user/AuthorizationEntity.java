package lmarek.stv.stv.user;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorizations", indexes = @Index(name = "find_by_name", columnList = "name", unique = true))
@Data
public class AuthorizationEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<UserEntity> users;

}
