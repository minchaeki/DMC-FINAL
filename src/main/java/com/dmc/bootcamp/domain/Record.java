package com.dmc.bootcamp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recordId;

    private String foodId; // foodId 필드 추가

    @Column(name = "record_date")
    private LocalDateTime recordDate;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private AppUser appUser;

    @Column(name = "score")
    private float score;

    @Builder
    public Record(String foodId, String image, String content, float score, AppUser appUser) {
        this.foodId = foodId; // foodId 초기화 추가
        this.content = content;
        this.image = image;
        this.score = score;
        this.appUser = appUser;
    }

    @PrePersist
    protected void onCreate() {
        this.recordDate = LocalDateTime.now();
    }

    public void update(String image, String content, float score) {
        this.content = content;
        this.image = image;
        this.score = score;
    }
}
