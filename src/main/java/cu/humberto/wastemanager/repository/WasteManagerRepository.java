package cu.humberto.wastemanager.repository;

import cu.humberto.wastemanager.entity.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerRepository extends JpaRepository<WasteManagerEntity,Long> {
}
