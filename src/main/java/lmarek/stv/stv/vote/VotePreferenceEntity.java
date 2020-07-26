package lmarek.stv.stv.vote;

import lmarek.stv.stv.candidate.CandidateEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "VOTE_COUNT")
@Data
public class VotePreferenceEntity {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private CandidateEntity candidate;

    @ManyToOne
    private VoteEntity vote;

    private long rank;
}
