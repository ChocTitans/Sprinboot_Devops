package gestion.stock.gstock.web;

import gestion.stock.gstock.entities.ProduitEntree;
import gestion.stock.gstock.repositories.ProduitEntreeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProduitEnController {
    private ProduitEntreeRepository produitEntreeRepository;

    @GetMapping(path = "/index")
    public String produitEntree(Model model, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "5") int size,
                                @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<ProduitEntree> pagepentree=produitEntreeRepository.findByNameContains(keyword,PageRequest.of(page, size));
        model.addAttribute("listProduits",pagepentree.getContent());
        model.addAttribute("pages",new  int[pagepentree.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "ProduitsEntree";
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        produitEntreeRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
 @GetMapping("/")
    public String home(){
        return "redirect:/index";
 }



 @GetMapping("/produits")
 public List<ProduitEntree> listProduits(){
     return produitEntreeRepository.findAll();
 }



@GetMapping("/formProduit")
 public String formProduit(Model model){
        model.addAttribute("produit",new ProduitEntree());
     return "formProduit";
 }




@PostMapping(path = "/save")
public String save(Model model, @Valid ProduitEntree produit, BindingResult bindingResult,
                   @RequestParam(defaultValue = "0") Integer page ,
                   @RequestParam(defaultValue = "") String keyword){
    if (bindingResult.hasErrors()) return "formProduit";
    produitEntreeRepository.save(produit);
    return "redirect:/index?page="+page+"&keyword="+keyword;
}



    @GetMapping("/editProduit")
    public String editProduit(Model model,Long id,String keyword, Integer page){
        ProduitEntree produit=produitEntreeRepository.findById(id).orElse(null);
        if(produit==null) throw new RuntimeException("Produit introuvable");
        model.addAttribute("produit",produit);
        model.addAttribute("page",page);
        model.addAttribute("keyword",keyword);
        return "editProduit";
    }

}
