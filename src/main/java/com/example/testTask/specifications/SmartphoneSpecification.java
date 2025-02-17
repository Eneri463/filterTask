package com.example.testTask.specifications;

import com.example.testTask.dto.SmartphoneParams;
import com.example.testTask.models.Smartphone;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SmartphoneSpecification extends ParticularModelSpecification<Smartphone>{
    public Specification<Smartphone> build(SmartphoneParams params)
    {
        return this.mainFilters(params).and(addFilters(params.getNumber_of_cameras(), params.getMemory_size()));
    }

    public Specification<Smartphone> addFilters(Integer numberOfCameras, Integer memorySize)
    {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            if (memorySize != null ) list.add(cb.equal(root.get("memorySize"), memorySize));
            if (numberOfCameras != null ) list.add(cb.equal(root.get("numberOfCameras"), numberOfCameras));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }
}
