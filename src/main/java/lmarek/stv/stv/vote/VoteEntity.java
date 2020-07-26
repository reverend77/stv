package lmarek.stv.stv.vote;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "VOTE")
public class VoteEntity {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "vote", fetch = FetchType.EAGER)
    private Set<VotePreferenceEntity> preferences;

}
