package tn.esprit.spring;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {

	@Autowired
	EntrepriseServiceImpl entrepriseService;
	
	
	
	
	
	@Test
	public void ajouterEntreprise() throws ParseException{
		
		Entreprise  entreprise = new Entreprise("TELNET","SCIENCE") ;
		entrepriseService.ajouterEntreprise(entreprise);
	}
	
	 
	
	@Test
	public void ajouterDepartement() throws ParseException{
	Departement departement = new Departement("Embarqué");
	entrepriseService.ajouterDepartement(departement);
	}
	
	
	@Test
	public void affecterDepartementAEntreprise()throws ParseException{
		
	entrepriseService.affecterDepartementAEntreprise(1,4);
				}
	
	
	@Test
	public void getAllDepartementsNamesByEntreprise() throws ParseException{
	entrepriseService.getAllDepartementsNamesByEntreprise(1);
	}
	
	
	
	@Test
	public void deleteEntrepriseById() throws ParseException{
		entrepriseService.deleteEntrepriseById(5);
	}
	
	
	@Test
	public void deleteDepartementById() throws ParseException{
	entrepriseService.deleteDepartementById(2);
	}
	
	@Test
	public void getEntrepriseById() throws ParseException{
	entrepriseService.getEntrepriseById(2);
	}
	
	
}

