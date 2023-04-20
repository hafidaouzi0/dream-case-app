package org.dreamCase.app.repository;

import org.dreamCase.app.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case,Long> {

   List<Case> findCaseByTitle(String title);
}
