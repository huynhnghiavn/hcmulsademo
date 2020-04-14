package vn.edu.hcmulsa.springboot_html.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.edu.hcmulsa.springboot_html.model.ProductEntity;

/**
 * Product Repository
 *
 * @author Huynh
 */

public interface ProductRepository  extends JpaRepository<ProductEntity, Integer>,
    JpaSpecificationExecutor<ProductEntity>{
}
