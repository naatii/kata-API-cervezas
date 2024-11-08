package daw2a.kataapicervezas.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Entity
@Table(name = "styles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cat_id", nullable = false)
    private int categoryId;

    @Column(name = "style_name", nullable = false, length = 255)
    private String styleName;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;
}
