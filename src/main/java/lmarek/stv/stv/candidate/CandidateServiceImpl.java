package lmarek.stv.stv.candidate;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Optional<CandidateDTO> getCandidate(long id) {
        final Optional<CandidateEntity> result = candidateRepository.findById(id);
        return result.map(entity -> new CandidateDTO(entity.getId(), entity.getDescription()));
    }
}
