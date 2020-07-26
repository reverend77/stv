package lmarek.stv.stv.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users", indexes = @Index(name = "find_by_email", columnList = "email", unique = true))
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    long id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String password;

}
