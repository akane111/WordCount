package com.gaoge.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_order")
@ApiModel(value = "oder",description = "订单")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Integer orderId;
    private String title;
    @Column(name = "price")
    private double price;
    private String content;
    private Integer orderStatu;
    @Column(name = "type")
    private String type;
    private String picture;
    private String ownName;
    private String cooperationName;
    private Date createTime;
    private Date updateTime;
    private Integer commentId;


}
