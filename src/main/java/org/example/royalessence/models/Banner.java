package org.example.royalessence.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "banners")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String message;
    private boolean active;

}
