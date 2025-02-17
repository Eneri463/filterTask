package com.example.testTask.specifications;

import com.example.testTask.dto.FridgeParams;
import com.example.testTask.models.Fridge;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FridgeSpecification extends ParticularModelSpecification<Fridge>{

    public Specification<Fridge> build(FridgeParams params)
    {
        return this.mainFilters(params).and(addFilters(params.getNumber_of_doors(), params.getCompressor()));
    }

    public Specification<Fridge> addFilters(Integer numberOfDoors, String compressorType)
    {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            root.fetch("compressorType");

            if (numberOfDoors != null ) list.add(cb.equal(root.get("numberOfDoors"), numberOfDoors));
            if (compressorType != null ) list.add(cb.equal(cb.upper(root.get("compressorType").get("name")), compressorType.toUpperCase()));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
