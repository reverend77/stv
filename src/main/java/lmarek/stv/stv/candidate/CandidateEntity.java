package lmarek.stv.stv.candidate;

import lmarek.stv.stv.election.ElectionEntity;
import lmarek.stv.stv.vote.VotePreferenceEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "candidates")
@Data
public class CandidateEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private ElectionEntity election;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VotePreferenceEntity> votes;
}
