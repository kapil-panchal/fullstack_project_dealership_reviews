package com.app60.springreviewscollection.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity(name = "Review")
@Table(name = "review",
        catalog = "app60cat",
        schema = "app60sch")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review implements Serializable {

    @Id
    @GeneratedValue(generator = "reviews_uuid2")
    @GenericGenerator(name = "reviews_uuid2", strategy = "uuid2")
    private UUID id;

    @Column(nullable = false)
    private String review;

    @Builder.Default
    private ZonedDateTime timeStamp = ZonedDateTime.now(ZoneId.of("Z"));
}