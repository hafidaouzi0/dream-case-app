package org.dreamCase.app.controller;


import lombok.RequiredArgsConstructor;
import org.dreamCase.app.entity.Case;
import org.dreamCase.app.service.CaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cases")
@RequiredArgsConstructor
public class CaseController {


    private final CaseService caseService;

    @PostMapping
    public Case createCase(@RequestBody Case newCase){

        try {
            return caseService.addCase(newCase);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public Case updateCase(@PathVariable(name = "id") Long id,@RequestBody Case updatedCase){

        try {
            return caseService.updateCase(id,updatedCase);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/{id}")
    public Case getCase(@PathVariable(name = "id") Long id){

        try {
            return caseService.getCase(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @DeleteMapping("/{id}")
    public String deleteCase(@PathVariable(name = "id") Long id){

        try {
            caseService.deleteCase(id);

            return  "case deleted successully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @GetMapping
    public List<Case> getAllCases(){
        try {
            return caseService.getAllCases();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
