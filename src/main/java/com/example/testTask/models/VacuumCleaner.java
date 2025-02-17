package com.example.testTask.models;

import com.example.testTask.dto.VacuumCleanerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vacuum_cleaner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacuumCleaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "volume")
    private double volume;

    @NotNull
    @Column(name = "number_of_modes")
    private int numberOfModes;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;

    public void vacuumCleanerToDTO(VacuumCleanerDTO res)
    {
        model.modelToModelDTO(res);
        res.setVolume(this.volume);
        res.setNumberOfModes(this.numberOfModes);
    }

    public VacuumCleanerDTO createDTO()
    {
        VacuumCleanerDTO res = new VacuumCleanerDTO();
        vacuumCleanerToDTO(res);
        return res;
    }

}
