package com.example.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "player_index")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerIndex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value", nullable = false)
    private Float value;

    // FK player_id
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    // FK index_id
    @ManyToOne
    @JoinColumn(name = "index_id", nullable = false)
    private Indexer indexer;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}