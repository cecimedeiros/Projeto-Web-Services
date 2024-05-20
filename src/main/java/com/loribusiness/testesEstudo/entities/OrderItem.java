package com.loribusiness.testesEstudo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loribusiness.testesEstudo.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    //isso pq um pedido tem itens mas tambem tem uma quantidade de itens, essa classe serve para ser isso.

    @EmbeddedId //vamos ser nós não a db que vai criar
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem(){}

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        //o id aqui ta sendo criado no grosso, decompondo os atributos que o compõe para criar ele aqui
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    //get e set de id não existe, existe dos atrinutos dele, dessa forma:
    @JsonIgnore //é aqui que o pedido ta sendo chamado, por isso deve ser colocado aqui
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal(){
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
