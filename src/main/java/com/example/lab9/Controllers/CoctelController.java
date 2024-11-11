package com.example.lab9.Controllers;


import com.example.lab9.Daos.CoctelDao;
import com.example.lab9.Entities.Coctel;
import com.example.lab9.Entities.CoctelFav;
import com.example.lab9.Repositories.CoctelFavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/coctel")
public class CoctelController {

    @Autowired
    private CoctelDao coctelDao;

    final CoctelFavRepository coctelFavRepository;

    public CoctelController(CoctelFavRepository coctelFavRepository) {
        this.coctelFavRepository = coctelFavRepository;
    }

    @GetMapping("/listaCocteles")
    public String listaCocteles(Model model) {
        model.addAttribute("cocteles", coctelDao.cocteles());

        return "listaCocteles";
    }

    @GetMapping("/detalle/{id}")
    public String detalleCoctel(@PathVariable String id, Model model) {
        Coctel coctel = coctelDao.getDetalleCoctel(id);
        model.addAttribute("coctel", coctel);
        boolean esFav = coctelFavRepository.existsById(Integer.valueOf(id));
        model.addAttribute("esFav", esFav);
        return "detalleCoctel";
    }

    @PostMapping("/anadirFav")
    public String addFavs(@RequestParam("id") String id,
                          @RequestParam("name") String name,
                          @RequestParam("thumbnail") String thumbnail,
                          RedirectAttributes redirectAttributes) {

        if(!coctelFavRepository.existsById(Integer.valueOf(id))){
            CoctelFav fav = new CoctelFav();
            fav.setId(Integer.valueOf(id));
            fav.setName(name);
            fav.setThumbnail(thumbnail);
            coctelFavRepository.save(fav);
            redirectAttributes.addFlashAttribute("mensajeExito","Se añadió a favoritos");
        }
        else{
            redirectAttributes.addFlashAttribute("mensajeFracaso","Esta bebida ya está en tus favoritas");
        }

        return "redirect:/coctel/detalle/" + id;
    }


}
