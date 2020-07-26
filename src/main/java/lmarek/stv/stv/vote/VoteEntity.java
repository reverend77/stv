package lmarek.stv.stv.vote;

import lmarek.stv.stv.voter.VoterEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "votes")
public class VoteEntity {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "vote", fetch = FetchType.EAGER)
    private Set<VotePreferenceEntity> preferences;

    @ManyToOne
    private VoterEntity voter;

}
