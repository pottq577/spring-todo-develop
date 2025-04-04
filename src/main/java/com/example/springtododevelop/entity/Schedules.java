package com.example.springtododevelop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedules")
public class Schedules extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(nullable = false)
    @Setter
    private String title;

    @Column(columnDefinition = "longtext", nullable = false)
    @Setter
    private String contents;

    @Setter
    @ManyToOne // N:1
    @JoinColumn(name = "user_id", nullable = false) // FK
    private Users user;

    public Schedules(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
