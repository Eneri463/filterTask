package com.example.testTask.dto;

import lombok.Data;

@Data
public class ParamsDTO {

    private String type; // вид техники
    private String search; // строка для поиска по наименованию
    private String country; // компания-производитель
    private String company; // фирма-производитель
    private String serial_number; // серийный номер
    private String size; // размер
    private Boolean online; // возможность заказа онлайн
    private Boolean installment; // возможность оплаты в рассрочку
    private Double min_price; // цена - нижняя граница
    private Double max_price; // цена - верхняя граница
    private String colour; // цвет
    private String sort; // тип сортировки

}
