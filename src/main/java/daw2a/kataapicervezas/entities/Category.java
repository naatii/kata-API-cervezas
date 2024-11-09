package daw2a.kataapicervezas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cat_name", nullable = false, length = 255)
    private String catName;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;
}
