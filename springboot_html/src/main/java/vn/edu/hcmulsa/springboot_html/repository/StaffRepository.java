package vn.edu.hcmulsa.springboot_html.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.hcmulsa.springboot_html.model.StaffEntity;

/**
 * Staff Repository
 *
 * @author Huynh
 */

public interface StaffRepository extends JpaRepository<StaffEntity, Integer>,
        JpaSpecificationExecutor<StaffEntity> {
}
