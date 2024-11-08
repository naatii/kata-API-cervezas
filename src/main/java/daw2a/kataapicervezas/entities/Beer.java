package daw2a.kataapicervezas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Entity
@Table(name = "beers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brewery_id", nullable = false)
    private int breweryId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "cat_id", nullable = false)
    private int categoryId;

    @Column(name = "style_id", nullable = false)
    private int styleId;

    @Column(name = "abv", nullable = false)
    private float abv;

    @Column(name = "ibu", nullable = false)
    private float ibu;

    @Column(name = "srm", nullable = false)
    private float srm;

    @Column(name = "upc", nullable = false)
    private int upc;

    @Column(name = "filepath", nullable = false, length = 255)
    private String filepath;

    @Column(name = "descript", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "add_user", nullable = false)
    private int addUser;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;
}
