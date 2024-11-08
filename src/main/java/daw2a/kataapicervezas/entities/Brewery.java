package daw2a.kataapicervezas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Entity
@Table(name = "breweries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "address1", nullable = false, length = 255)
    private String address1;

    @Column(name = "address2", nullable = false, length = 255)
    private String address2;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name = "state", nullable = false, length = 255)
    private String state;

    @Column(name = "code", nullable = false, length = 25)
    private String code;

    @Column(name = "country", nullable = false, length = 255)
    private String country;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "website", nullable = false, length = 255)
    private String website;

    @Column(name = "filepath", nullable = false, length = 255)
    private String filepath;

    @Column(name = "descript", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "add_user", nullable = false)
    private int addUser;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;
}
