package org.dreamCase.app.service;


import org.dreamCase.app.entity.Case;

import java.util.List;

public interface CaseService {

    Case addCase(Case newCase) throws Exception ;
    Case updateCase(Long id,Case updatedCase) throws Exception;
    boolean deleteCase(Long id) throws Exception;
    Case getCase(Long id) throws Exception;
    List<Case> getAllCases() throws Exception;


}
