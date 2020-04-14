package vn.edu.hcmulsa.springboot_html.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Detail of bill
 * @author Huynh
 */

@Entity
@Table(name="billdetails")
@Data
public class BillDetailEntity {

    @Id
    @Column(name="billid")
    private Integer billid;
    @Column(name="productid")
    private Integer productid;
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="price")
    private Integer price;


    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
