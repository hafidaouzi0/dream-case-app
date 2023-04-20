package org.dreamCase.app.service;

import org.dreamCase.app.entity.Case;
import org.dreamCase.app.repository.CaseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CaseServiceImplTest {

    @Mock
    private CaseRepository caseRepository;
    private  CaseService caseService;
    AutoCloseable autoCloseable;
    Case aCase;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        caseService=new CaseServiceImpl(caseRepository);
        aCase=new Case(LocalDateTime.now(),LocalDateTime.now(),"Amazon","description service test");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testAddCase() throws Exception {
        mock(Case.class);
        mock(CaseRepository.class);
        when(caseRepository.save(aCase)).thenReturn(aCase);
        assertThat(caseService.addCase(aCase)).isEqualTo(aCase);
    }

    @Test
    void testUpdateCase() throws Exception{
        mock(Case.class);
        mock(CaseRepository.class);
        given(caseRepository.save(aCase)).willReturn(aCase);
        given(caseRepository.findById(aCase.getCaseId())).willReturn(Optional.of(aCase));

        aCase.setTitle("New Title");
         aCase.setDescription("New Description");
         Case updatedCase = caseService.updateCase(aCase.getCaseId(), aCase);

        assertThat(updatedCase).isEqualTo(aCase);
      when(caseRepository.save(aCase)).thenReturn(aCase);
       assertThat(caseService.updateCase(aCase.getCaseId(),aCase)).isEqualTo(aCase);

    }


    @Test
    void testDeleteCase() throws Exception {
        mock(Case.class);
        mock(CaseRepository.class);
        when(caseRepository.findById(aCase.getCaseId())).thenReturn(Optional.of(aCase));
        Boolean result = caseService.deleteCase(aCase.getCaseId());
        assertThat(result).isTrue();
       // assertThat(caseRepository.findById(aCase.getCaseId())).isEqualTo(true);

    }

    @Test
    void testGetCase() throws Exception {
        mock(Case.class);
        mock(CaseRepository.class);
        when(caseRepository.findById(aCase.getCaseId())).thenReturn(Optional.of(aCase));
        Case retrievedCase = caseService.getCase(aCase.getCaseId());
        assertThat(retrievedCase).isEqualTo(aCase);

    }

    @Test
    void testGetAllCases() throws Exception {
        mock(Case.class);
        mock(CaseRepository.class);
        List<Case> caseList = new ArrayList<>();
        caseList.add(aCase);
        when(caseRepository.findAll()).thenReturn(caseList);
        List<Case> retrievedCaseList = caseService.getAllCases();
        assertThat(retrievedCaseList).isEqualTo(caseList);
    }
}