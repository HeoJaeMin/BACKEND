package task.jmheo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.jmheo.backend.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, String>{

}
