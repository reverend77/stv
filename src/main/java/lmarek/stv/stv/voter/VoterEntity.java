package lmarek.stv.stv.voter;

import lmarek.stv.stv.vote.VoteEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "voters")
@Data
public class VoterEntity {
    @OneToMany(mappedBy = "voter")
    final List<VoteEntity> votes;
    @Id
    @GeneratedValue
    private long id;
}
