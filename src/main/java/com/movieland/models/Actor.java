package com.movieland.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

}
