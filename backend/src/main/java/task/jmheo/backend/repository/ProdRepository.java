package task.jmheo.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import task.jmheo.backend.entity.Prod;

public interface ProdRepository extends JpaRepository<Prod, String>{
	Optional<List<Prod>> findByProdDvsCdStartsWithAndUseYn(String prodDvsCd, String useYn);
}
