package com.esprit.examen.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
Junit4
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;

*/

/* Juint5 */
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.* ;


import com.esprit.examen.entities.Produit;



//@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {
	@Autowired
	IProduitService prodService;

	
	@Test
	public void testAddProd() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation= dateFormat.parse("30/09/2000");
		Date dateMod = dateFormat.parse("30/09/2001");
		Produit c = new Produit("10","prod1",11, dateCreation, dateMod);
		Produit produit = prodService.addProduit(c);
		System.out.print("produit "+produit);
		assertNotNull(produit.getIdProduit());
		prodService.deleteProduit(produit.getIdProduit());

	}

	@Test
	public void testDeleteProd() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation= dateFormat.parse("30/09/2000");
		Date dateMod = dateFormat.parse("30/09/2001");
		Produit c = new Produit("10","prod1",11, dateCreation, dateMod);
		Produit produit = prodService.addProduit(c);
		prodService.deleteProduit(produit.getIdProduit());
		assertNull(prodService.retrieveProduit(produit.getIdProduit()));
	}

	@Test
	public void testRetrieveAllProduits() throws ParseException {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation= dateFormat.parse("30/09/2000");
		Date dateMod = dateFormat.parse("30/09/2001");
		List<Produit> produits = prodService.retrieveAllProduits();
		int expected = produits.size();
		Produit c = new Produit("10","prod1",11, dateCreation, dateMod);
		Produit produit = prodService.addProduit(c);
		assertEquals(expected + 1, prodService.retrieveAllProduits().size());
		prodService.deleteProduit(produits.getIdProduit());

	}

}
