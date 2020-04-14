package vn.edu.hcmulsa.springboot_html.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.hcmulsa.springboot_html.model.BillDetailEntity;

/**
 * Bill Detail Repository
 * @author Huynh
 */
public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Integer>,
        JpaSpecificationExecutor<BillDetailEntity> {
}
