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
		Client c = new Produit("10","prod1",11.2, dateCreation, dateMod);
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
		Client c = new Produit("10","prod1",11.2, dateCreation, dateMod);
		Produit produit = prodService.addProduit(c);
		prodService.deleteProduit(produit.getIdProduit());
		assertNull(prodService.retrieveProduit(produit.getIdProduit()));
	}
/*
	@Test
	public void testRetrieveAllClients() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = dateFormat.parse("30/09/2000");
		List<Client> clients = clientService.retrieveAllClients();
		int expected = clients.size();
		Client c = new Client("Salhi", "Ahmed", dateNaissance, "ahmed.salhi@esprit.tn", "pwd", Profession.Cadre,
				CategorieClient.Ordinaire);
		Client client = clientService.addClient(c);
		assertEquals(expected + 1, clientService.retrieveAllClients().size());
		clientService.deleteClient(client.getIdClient());

	}
	@Test
	public void testGetClientsByDateNaissance() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = dateFormat.parse("28/09/2000");
		Date endDate = dateFormat.parse("30/09/2005");
		List<Client> clients = clientService.getClientsByDateNaissance(startDate, endDate);
		log.info(" count" + clients.size());
		for (Client client : clients) {
			log.info(" client : " + client.getNom()+ " né le "+client.getDateNaissance());

		}
	}
*/
}
