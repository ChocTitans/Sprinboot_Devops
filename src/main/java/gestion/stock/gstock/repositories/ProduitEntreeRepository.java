package gestion.stock.gstock.repositories;

import gestion.stock.gstock.entities.ProduitEntree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitEntreeRepository extends JpaRepository<ProduitEntree, Long> {
    Page<ProduitEntree> findByNameContains(String kw, Pageable pageable);
}
