package com.movieland.models;

import com.movieland.enums.GenreName;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "genres", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreName name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;

    public Genre(GenreName name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }
}
