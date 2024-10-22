package com.manga.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Table(name = "state")
@Getter
@Setter
public class StateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    @OneToMany(mappedBy = "state")
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Set<ComicModel> comics;

    public StateModel() {}

    public StateModel(String name) {
        this.name = name;
    }

}
