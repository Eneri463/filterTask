package com.example.testTask.specifications;

import com.example.testTask.dto.TelevisionParams;
import com.example.testTask.models.Television;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelevisionSpecification extends ParticularModelSpecification<Television>{

    public Specification<Television> build(TelevisionParams params)
    {
        return this.mainFilters(params).and(addFilters(params.getCategory(), params.getTechnology()));
    }

    public Specification<Television> addFilters(String category, String technology)
    {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            root.fetch("category");
            root.fetch("technology");

            if (category != null ) list.add(cb.equal(cb.upper(root.get("category").get("name")), category.toUpperCase()));
            if (technology != null ) list.add(cb.equal(cb.upper(root.get("technology").get("name")), technology.toUpperCase()));

            Predicate[] p = new Predicate[list.size()];

            return cb.and(list.toArray(p));
        };
    }
}
