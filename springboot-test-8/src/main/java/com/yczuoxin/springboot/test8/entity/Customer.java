package com.yczuoxin.springboot.test8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yczuoxin.springboot.test8.entity.listener.CustomerListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Access(value = AccessType.FIELD)
@EntityListeners(value = {CustomerListener.class})
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @OneToOne
    private IDCard idCard;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Store store;

    @ManyToMany
    private List<Goods> goods;

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    private List<Child> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard=" + idCard +
                ", store=" + store +
                ", goods=" + goods +
                ", children=" + children +
                '}';
    }
}
