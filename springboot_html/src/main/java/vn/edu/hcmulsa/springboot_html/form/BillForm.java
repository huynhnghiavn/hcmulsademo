package vn.edu.hcmulsa.springboot_html.form;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Bill form
 * @author Huynh
 */
public class BillForm {
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
