package task.jmheo.backend.service;

import org.springframework.stereotype.Service;

import task.jmheo.backend.entity.ProdDvs;
import task.jmheo.backend.repository.ProdDvsRepository;

@Service
public class ProdDvsService {

	ProdDvsRepository repo;

	public ProdDvsService(ProdDvsRepository repo) {
		super();
		this.repo = repo;
	}
	
	public ProdDvs search(String target) {
		return repo.findById(target).orElseThrow();
	}
}
