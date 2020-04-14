package vn.edu.hcmulsa.springboot_html.form;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Bill detail form
 * @author Huynh
 */
public class BillDetailForm {
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
