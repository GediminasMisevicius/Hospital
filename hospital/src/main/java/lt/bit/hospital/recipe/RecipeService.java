package lt.bit.hospital.recipe;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@Transactional
public class RecipeService {
	
	private RecipeJpaRepository repository;
	
	public RecipeService(RecipeJpaRepository repository) {
		this.repository = repository;
	}
	
	

}
