package lmarek.stv.stv.election;

import lmarek.stv.stv.candidate.CandidateEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "elections")
@Data
public class ElectionEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CandidateEntity> candidates;
}
