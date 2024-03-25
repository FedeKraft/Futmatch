package database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(generator = "userGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column()
    private String firstName;

    @Column()
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private final List<Publication> publications = new ArrayList<>();

    @ManyToMany(mappedBy = "liked")
    private final List<Publication> likes = new ArrayList<>();

    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void likes(Publication publication) {
        likes.add(publication);
        publication.isLikedBy(this);
    }

    public void addPublication(Publication publication) {
        publication.isPublishedBy(this);
        publications.add(publication);
    }

}
