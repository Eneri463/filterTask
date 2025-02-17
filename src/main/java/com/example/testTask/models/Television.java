package com.example.testTask.models;

import com.example.testTask.dto.TelevisionDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "television")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private TelevisionCategory category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "technology_id")
    private TelevisionTechnology technology;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;

    public void televisionToDTO(TelevisionDTO res)
    {
        model.modelToModelDTO(res);
        res.setCategory(this.category.getName());
        res.setTechnology(this.technology.getName());
    }

    public TelevisionDTO createDTO()
    {
        TelevisionDTO res = new TelevisionDTO();
        televisionToDTO(res);
        return res;
    }
}
