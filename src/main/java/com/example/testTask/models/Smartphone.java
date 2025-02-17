package com.example.testTask.models;

import com.example.testTask.dto.SmartphoneDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "smartphones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "memory_size")
    private int memorySize;

    @NotNull
    @Column(name = "number_of_cameras")
    private int numberOfCameras;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;

    public void smartphoneToDTO(SmartphoneDTO res)
    {
        model.modelToModelDTO(res);
        res.setMemorySize(this.memorySize);
        res.setNumberOfCameras(this.numberOfCameras);
    }

    public SmartphoneDTO createDTO()
    {
        SmartphoneDTO res = new SmartphoneDTO();
        smartphoneToDTO(res);
        return res;
    }

}
