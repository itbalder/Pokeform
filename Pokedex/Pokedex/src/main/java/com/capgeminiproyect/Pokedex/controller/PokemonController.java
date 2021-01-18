package com.capgeminiproyect.Pokedex.controller;

import com.capgeminiproyect.Pokedex.persistense.Pokemon;
import com.capgeminiproyect.Pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;
@Controller
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    // display list of employees

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "numeroPokedex", "asc", model);
    }

    @GetMapping("/showNewPokemonForm")
    public String showNewPokemonForm(Model model) {
        // create model attribute to bind form data
        Pokemon pokemon = new Pokemon();
        model.addAttribute("pokemon", pokemon);
        return "new_pokemon";
    }

    @PostMapping("/savePokemon")
    public String saveEmployee(@ModelAttribute("pokemon") Pokemon pokemon) {
        // save employee to database
        pokemonService.savePokemon(pokemon);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {


        Pokemon pokemon = pokemonService.getPokemonById(id);


        model.addAttribute("pokemon", pokemon);
        return "update_pokemon";
    }

    @GetMapping("/deletePokemon/{id}")
    public String deletePokemon(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.pokemonService.deletePokemonById(id);
        return "redirect:/";
    }





    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Pokemon> page = pokemonService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Pokemon> listPokemon = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listPokemon", listPokemon);
        return "index";
    }
}
