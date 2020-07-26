package lmarek.stv.stv.candidate;

import lmarek.stv.stv.election.ElectionEntity;
import lombok.Data;

import javax.persistence.*;

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
}
