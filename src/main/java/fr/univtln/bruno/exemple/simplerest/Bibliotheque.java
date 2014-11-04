package fr.univtln.bruno.exemple.simplerest;


import fr.univtln.bruno.d14.simpleihm.Auteur;
import fr.univtln.bruno.d14.simpleihm.ModeleBibliotheque;

import javax.ws.rs.*;
import java.util.List;

// The Java class will be hosted at the URI path "/myresource"
@Path("/biblio")
//@Produces({"application/json", "application/xml"})
@Produces("application/json")
public class Bibliotheque {

    private final static ModeleBibliotheque modeleBibliotheque = new ModeleBibliotheque();

    static {
        modeleBibliotheque.ajouterAuteur(new Auteur.AuteurBuilder().setPrenom("Jean").setNom("Martin").createAuteur());
        modeleBibliotheque.ajouterAuteur(new Auteur.AuteurBuilder().setPrenom("Marie").setNom("Durand").createAuteur());
    }

    @PUT
    @Path("auteur")
    public void ajouterAuteur(@PathParam("prenom") String prenom, @PathParam("nom") String nom) {
        modeleBibliotheque.ajouterAuteur(prenom, nom);
    }

    @DELETE
    @Path("auteur/{id}")
    public void supprimerAuteur(@PathParam("id") final int ID) {
        modeleBibliotheque.supprimerAuteur(ID);
    }

    @GET
    @Path("auteur/{id}")
    public Auteur getAuteur(@PathParam("id") final int ID) {
        Auteur auteur = modeleBibliotheque.getAuteur(ID);
        return auteur;
    }

    @GET
    @Path("auteurs")
    public List<Auteur> getAuteurs() {
        return modeleBibliotheque.getAuteurs();
    }
}
