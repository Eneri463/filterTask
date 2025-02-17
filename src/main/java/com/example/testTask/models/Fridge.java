package com.example.testTask.models;

import com.example.testTask.dto.FridgeDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fridge")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "number_of_doors")
    private int numberOfDoors;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "compressor_type_id")
    private FridgeCompressorType compressorType;

    @NotNull
    @OneToOne
    @JoinColumn(name = "model_id")
    private Model model;

    public void fridgeToDTO(FridgeDTO res)
    {
        model.modelToModelDTO(res);
        res.setNumberOfDoors(this.numberOfDoors);
        res.setCompressor(this.compressorType.getName());
    }

    public FridgeDTO createDTO()
    {
        FridgeDTO res = new FridgeDTO();
        fridgeToDTO(res);
        return res;
    }
}
