package org.dreamCase.app.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "cases")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    @Column(name = "creele")
    private LocalDateTime creationDate;
    @Column(name = "changeele")
    private LocalDateTime lastUpdateDate;
    @Column(name = "titre",length = 255)
    private String title;
    @Column(name = "descirption",length = 2056)
    private String description;



    public Case(LocalDateTime creationDate, LocalDateTime lastUpdateDate, String title, String description) {
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.title = title;
        this.description = description;
    }
}
