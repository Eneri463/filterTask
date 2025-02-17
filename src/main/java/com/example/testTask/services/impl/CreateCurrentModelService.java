package com.example.testTask.services.impl;

import com.example.testTask.dto.ModelDTO;
import com.example.testTask.dto.ModelRequestDTO;
import com.example.testTask.models.*;
import com.example.testTask.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCurrentModelService {
    @Autowired
    ApplianceServiceInterface applianceService;
    @Autowired
    ColourServiceInterface colourService;
    @Autowired
    SizeServiceInterface sizeService;
    @Autowired
    ModelServiceInterface modelService;

    public Model createModel(ModelRequestDTO request)
    {
        Appliance appliance = applianceService.getById(request.getApplianceId());

        Colour colour = colourService.getByName(request.getColour());

        if (colour == null)
            colour = colourService.create(new Colour(null, request.getColour()));

        Size size = sizeService.getByNameAndType(request.getSize(), appliance.getType());

        if (size == null)
            size = sizeService.create(new Size(null, request.getSize(), appliance.getType()));

        Model model = new Model(null, request.getName(), request.getSerialNumber(), colour, size, request.getPrice(), request.isAvailable(), appliance);

        return modelService.create(model);
    }
}
