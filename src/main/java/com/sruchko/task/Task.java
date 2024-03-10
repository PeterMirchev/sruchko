package com.sruchko.task;

import com.sruchko.user.model.User;
import com.sruchko.worker.Worker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(nullable = false, referencedColumnName = "id", name = "user_id")
    private UUID userId;
    private BigDecimal price;
    @OneToOne
    private Worker worker;
}
