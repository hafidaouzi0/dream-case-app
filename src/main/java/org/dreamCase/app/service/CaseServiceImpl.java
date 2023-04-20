package org.dreamCase.app.service;


import lombok.RequiredArgsConstructor;
import org.dreamCase.app.entity.Case;
import org.dreamCase.app.repository.CaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;

    //Adding a case
    @Override
    public Case addCase(Case newCase) throws Exception {

            newCase.setCreationDate(LocalDateTime.now());
            newCase.setLastUpdateDate(LocalDateTime.now());
            return caseRepository.save(newCase);
    }

    @Override
    public Case updateCase(Long id,Case updatedCase) throws Exception {
        Case existingCase = caseRepository.findById(id).orElse(null);

            existingCase.setTitle(updatedCase.getTitle());
            existingCase.setDescription(updatedCase.getDescription());
            existingCase.setLastUpdateDate(LocalDateTime.now());
            return caseRepository.save(existingCase);
        }


    @Override
    public boolean deleteCase(Long id) throws Exception {
    Optional<Case> existingCase= caseRepository.findById(id);
    if(existingCase.isPresent()){
        caseRepository.deleteById(id);
        return true;
    }
    else {
        throw new RuntimeException("this case doesn't exist");

    }

    }

    @Override
    public Case getCase(Long id) throws Exception {

        return caseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Case> getAllCases() throws Exception {

        return caseRepository.findAll();
    }
}
