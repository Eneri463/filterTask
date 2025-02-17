package com.example.testTask.specifications;

import com.example.testTask.dto.ComputerParams;
import com.example.testTask.models.*;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComputerSpecification extends ParticularModelSpecification<Computer>{

    public Specification<Computer> build(ComputerParams params)
    {
        return this.mainFilters(params).and(addFilters(params.getCategory(), params.getProcessor()));
    }

    public Specification<Computer> addFilters(String category, String processorType)
    {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            root.fetch("category");
            root.fetch("processorType");

            if (category != null ) list.add(cb.equal(cb.upper(root.get("category").get("name")), category.toUpperCase()));
            if (processorType != null ) list.add(cb.equal(cb.upper(root.get("processorType").get("name")), processorType.toUpperCase()));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }

}
