package task.jmheo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.jmheo.backend.entity.Prod;

public interface ProdRepository extends JpaRepository<Prod, String>{

}
