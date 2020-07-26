package lmarek.stv.stv.candidate;

import java.util.Optional;

public interface CandidateService {
    Optional<CandidateDTO> getCandidate(long id);
}
