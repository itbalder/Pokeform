package com.capgeminiproyect.Pokedex.persistense;
import javax.persistence.*;
@Entity
@Table(name = "pokemones")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "numero_pokedex")
    private String numeroPokedex;

    @Column(name = "nombre_pokemon")
    private String nombrePokemon;
    @Column(name="tipo_1")
    private String tipoUno;
    @Column(name="tipo_2")
    private String tipoDos;
    private String descripcion;

    public String getTipoUno() {
        return tipoUno;
    }

    public void setTipoUno(String tipoUno) {
        this.tipoUno = tipoUno;
    }

    public String getTipoDos() {
        return tipoDos;
    }

    public void setTipoDos(String tipoDos) {
        this.tipoDos = tipoDos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(String numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }
}
