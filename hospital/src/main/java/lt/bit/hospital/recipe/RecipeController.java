//package lt.bit.hospital.recipe;
//
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//
//
//@Controller
//public class RecipeController {
//	
//	private RecipeServiceImpl recipeService;
//	
//	public RecipeController(RecipeServiceImpl recipeService) {
//		this.recipeService = recipeService;
//	}
//	
//	@GetMapping("/info/{id}/recipes")
//	public String getPatientRecipes(@PathVariable String id, Model model) {
//		
//		return "recipe";
//	}
//	
//	@PostMapping("/{id}/addRecipe")
//	public String addPatientRecipe(@PathVariable String id, HttpServletRequest request) {
//		
//		return "recipe";
//	}
//	
//	@PutMapping("/edit")
//	public String editPatientInfo(Model model, HttpServletRequest request) {
//		
//		return "edit";
//	}
//
//}
