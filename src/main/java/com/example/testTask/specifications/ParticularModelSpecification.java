package com.example.testTask.specifications;

import com.example.testTask.dto.ParamsDTO;
import com.example.testTask.models.Appliance;
import com.example.testTask.models.Model;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ParticularModelSpecification <T>{

    public Specification<T> mainFilters(ParamsDTO paramsDTO) {
        return (root, query, cb) -> {

            List<Predicate> list = new ArrayList<Predicate>();

            Fetch<Model, Appliance> model = root.fetch("model", JoinType.LEFT);
            Fetch<Model, Appliance> appliance = model.fetch("appliance", JoinType.LEFT);

            model.fetch("colour");
            model.fetch("size");
            appliance.fetch("type");
            appliance.fetch("producerCountry");
            appliance.fetch("producerCompany");

            // фильтрация
            if (paramsDTO.getCountry() != null ) list.add(cb.equal(root.get("model").get("appliance").get("producerCountry").get("name"), paramsDTO.getCountry()));
            if (paramsDTO.getCompany() != null ) list.add(cb.equal(root.get("model").get("appliance").get("producerCompany").get("name"), paramsDTO.getCompany()));
            if (paramsDTO.getOnline() != null ) list.add(cb.equal(root.get("model").get("appliance").get("onlineOrder"), paramsDTO.getOnline()));
            if (paramsDTO.getInstallment() != null ) list.add(cb.equal(root.get("model").get("appliance").get("installmentPlan"), paramsDTO.getInstallment()));
            if (paramsDTO.getMin_price() != null) list.add(cb.greaterThanOrEqualTo(root.get("model").get("price"), paramsDTO.getMin_price()));
            if (paramsDTO.getMax_price() != null) list.add(cb.lessThanOrEqualTo(root.get("model").get("price"), paramsDTO.getMax_price()));
            if (paramsDTO.getColour() != null ) list.add(cb.equal(root.get("model").get("colour").get("name"), paramsDTO.getColour()));
            if (paramsDTO.getSize() != null ) list.add(cb.equal(root.get("model").get("size").get("size"), paramsDTO.getSize()));
            if (paramsDTO.getSerial_number() != null ) list.add(cb.equal(root.get("model").get("serialNumber"), paramsDTO.getSerial_number()));

            // сортировка
            if (paramsDTO.getSort() != null) {

                String[] partOfOrder = paramsDTO.getSort().split(",");

                if (partOfOrder[0].toUpperCase().equals("PRICE"))
                    if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase().equals("DESC"))
                        query.orderBy(cb.desc(root.get("model").get("price")));
                    else query.orderBy(cb.asc(root.get("model").get("price")));
                else if (partOfOrder.length > 1 && partOfOrder[1].toUpperCase().equals("DESC"))
                    query.orderBy(cb.desc(root.get("model").get("name")));
                else query.orderBy(cb.asc(root.get("model").get("name")));
            } else query.orderBy(cb.asc(root.get("model").get("name")));

            // поиск
            if (paramsDTO.getSearch() != null)
            {
                List<Predicate> list2 = new ArrayList<Predicate>();
                Predicate[] p2 = new Predicate[list2.size()];

                String requiredStr = "%"+ paramsDTO.getSearch().toUpperCase() + "%";

                list2.add(cb.like(cb.upper(root.get("model").get("name")), requiredStr));
                list2.add(cb.like(cb.upper(root.get("model").get("appliance").get("producerCountry").get("name")), requiredStr));
                list2.add(cb.like(cb.upper(root.get("model").get("appliance").get("producerCompany").get("name")), requiredStr));

                Predicate[] p = new Predicate[list2.size()];
                list.add(cb.or(list2.toArray(p)));
            }

            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        };
    }

}
