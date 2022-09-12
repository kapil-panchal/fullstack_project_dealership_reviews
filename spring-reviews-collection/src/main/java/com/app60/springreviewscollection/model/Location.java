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
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "Location")
@Table(name = "location",
        catalog = "app60cat",
        schema = "app60sch")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Location implements Serializable {

    @Id
    @GeneratedValue(generator = "reviews_uuid2")
    @GenericGenerator(name = "reviews_uuid2", strategy = "uuid2")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String state;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(name = "location_reviews",
            joinColumns = @JoinColumn(
                    name = "location_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "review_id",
                    referencedColumnName = "id"),
            schema = "app60sch",
            catalog = "app60cat")
    private Collection<Review> reviews = new ArrayList<>();
}