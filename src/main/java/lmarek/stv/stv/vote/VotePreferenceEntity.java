package lmarek.stv.stv.vote;

import lmarek.stv.stv.candidate.CandidateEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "votes_preferences")
@Data
public class VotePreferenceEntity {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private CandidateEntity candidate;

    @ManyToOne(optional = false)
    private VoteEntity vote;

    @Column(nullable = false)
    private long rank;
}
