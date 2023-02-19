package gestion.stock.gstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(ProduitEntreeRepository produitEntreeRepository){
//		return args -> { produitEntreeRepository.save(new ProduitEntree(null,"produit1","390DH",30));
//			produitEntreeRepository.save(new ProduitEntree(null,"produit2","440DH",40));
 //produitEntreeRepository.findAll().forEach(p->{
//System.out.println(p.getName());
//});
//		};
//	}
}
