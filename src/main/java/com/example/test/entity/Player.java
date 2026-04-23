package com.example.test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "full_name", nullable = false, length = 128)
    private String fullName;

    @Column(name = "age", nullable = false, length = 10)
    private String age;

    // FK index_id
    @ManyToOne
    @JoinColumn(name = "index_id", nullable = false)
    private Indexer indexer;

    // Quan hệ 1-n với PlayerIndex
    @OneToMany(mappedBy = "player")
    private List<PlayerIndex> playerIndexes;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Indexer getIndexer() {
        return indexer;
    }

    public void setIndexer(Indexer indexer) {
        this.indexer = indexer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlayerIndex> getPlayerIndexes() {
        return playerIndexes;
    }

    public void setPlayerIndexes(List<PlayerIndex> playerIndexes) {
        this.playerIndexes = playerIndexes;
    }
}