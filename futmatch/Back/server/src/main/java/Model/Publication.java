package database;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String description;

    @Column
    private LocalDateTime creationDate;

    @ManyToOne
    private User author;

    @ManyToMany()
    private final List<User> liked = new ArrayList<>();

    public void isLikedBy(User user) {
        liked.add(user);
    }

}

