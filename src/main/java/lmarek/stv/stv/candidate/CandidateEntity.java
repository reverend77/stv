package lmarek.stv.stv.candidate;

import lmarek.stv.stv.election.ElectionEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CANDIDATE")
@Data
public class CandidateEntity {

    @Id
    @GeneratedValue
    private long id;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private ElectionEntity election;
}
