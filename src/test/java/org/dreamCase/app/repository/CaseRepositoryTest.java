package org.dreamCase.app.repository;


import org.dreamCase.app.entity.Case;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CaseRepositoryTest {

    @Autowired
private CaseRepository caseRepository;

    Case aCase;
    @BeforeEach
    void setUp(){
        aCase=new Case( LocalDateTime.now(),LocalDateTime.now(),"Amazon","testing decription");
        caseRepository.save(aCase);
    }

    @AfterEach
    void tearDown(){
        aCase=null;
        caseRepository.deleteAll();

    }



    @Test
    void findCaseByTitle_Found(){
      List<Case> caseList= caseRepository.findCaseByTitle("Amazon");
      assertThat(caseList.get(0).getCaseId()).isEqualTo(aCase.getCaseId());
      assertThat(caseList.get(0).getDescription()).isEqualTo(aCase.getDescription());
        //assertThat(caseList.get(0)).isEqualToComparingFieldByField(aCase);

    }


    //test case failure

    @Test
    void findCaseByTitle_NotFound(){
        List<Case> caseList= caseRepository.findCaseByTitle("Google");
        assertThat(caseList.isEmpty()).isTrue();
    }

}
