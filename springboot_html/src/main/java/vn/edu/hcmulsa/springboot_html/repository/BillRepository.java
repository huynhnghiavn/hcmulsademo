package vn.edu.hcmulsa.springboot_html.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.hcmulsa.springboot_html.model.BillEntity;

/**
 * Bill Repository
 * @author Huynh
 */
public interface BillRepository extends JpaRepository<BillEntity, Integer>,
        JpaSpecificationExecutor<BillEntity> {

}
