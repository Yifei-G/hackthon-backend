package com.schwarz.matrixapi.modules.messages.model;

import com.schwarz.matrixapi.infrastructure.model.Auditable;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
public class Message extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

}
