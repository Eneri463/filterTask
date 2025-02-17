package com.example.testTask.models;

import com.example.testTask.dto.ApplianceDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "appliances")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appliance_id")
    private ApplianceType type; // вид товара

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private ProducerCountry producerCountry; // компания-производитель

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private ProducerCompany producerCompany; // фирма-производитель

    @NotNull
    @Column(name = "online_order")
    private boolean onlineOrder; // возможность заказа онлайн

    @NotNull
    @Column(name = "installment_plan")
    private boolean installmentPlan; // возможность оплаты в рассрочку

    public void applianceToDTO(ApplianceDTO res)
    {
        res.setApplianceId(this.id);
        res.setType(this.getType().getName());
        res.setCompany(this.producerCompany.getName());
        res.setCountry(this.producerCountry.getName());
        res.setOnlineOrder(this.onlineOrder);
        res.setInstallment(this.installmentPlan);
    }

    public ApplianceDTO createDTO()
    {
        ApplianceDTO res = new ApplianceDTO();
        applianceToDTO(res);
        return res;
    }


}
