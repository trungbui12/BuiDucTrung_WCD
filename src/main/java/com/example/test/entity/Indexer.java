package com.example.test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "indexer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Indexer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index_id")
    private Integer indexId;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "valueMin", nullable = false)
    private Float valueMin;

    @Column(name = "valueMax", nullable = false)
    private Float valueMax;

    // Quan hệ 1-n với Player
    @OneToMany(mappedBy = "indexer")
    private List<Player> players;

    // Quan hệ 1-n với PlayerIndex
    @OneToMany(mappedBy = "indexer")
    private List<PlayerIndex> playerIndexes;

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Float getValueMax() {
        return valueMax;
    }

    public void setValueMax(Float valueMax) {
        this.valueMax = valueMax;
    }

    public Float getValueMin() {
        return valueMin;
    }

    public void setValueMin(Float valueMin) {
        this.valueMin = valueMin;
    }
}