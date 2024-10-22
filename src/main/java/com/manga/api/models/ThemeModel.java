package com.manga.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "theme")
@Getter
@Setter
public class ThemeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, mappedBy = "themes")
    @JsonIgnore
    private Set<ComicModel> comics = new HashSet<>();

    public ThemeModel() {}

    public ThemeModel(String name) {
        this.name = name;
    }
}
