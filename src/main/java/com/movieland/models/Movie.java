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
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @Column(nullable = false)
    private List<Genre> genres;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String director;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @Column(nullable = false)
    private List<Actor> actors;
    @Column(nullable = false)
    private LocalDate releaseDate;
    @Column(nullable = false)
    private double rating;

    public Movie(String name, List<Genre> genres, String description, String director, List<Actor> actors, LocalDate releaseDate, double rating) {
        this.name = name;
        this.genres = genres;
        this.description = description;
        this.director = director;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }
}
