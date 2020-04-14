package vn.edu.hcmulsa.springboot_html.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Bill Entity
 * @author Huynh
 */

@Entity
@Table(name="bills")
@Data
public class BillEntity {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="staffid")
    private Integer staffid;
    @Column(name="billdate")
    private Date billdate;
    @Column(name="kind")
    private String kind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
