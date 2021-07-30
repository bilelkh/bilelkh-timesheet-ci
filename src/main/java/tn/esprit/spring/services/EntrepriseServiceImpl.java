package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	private static final Logger logger = Logger.getLogger(EntrepriseServiceImpl.class);
	
	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		entrepriseRepoistory.save(entreprise);
		logger.info("Entreprise added successfully");
		return entreprise.getId();
		
	}	
	@Override
	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		logger.info("Departement added successfully");
		return dep.getId();
	}
	
	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
				Departement depManagedEntity = deptRepoistory.findById(depId).orElse(null);
				logger.info("In affecterDepartementAEntreprise method : Departement not affected");
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
				logger.info("Out affecterDepartementAEntreprise method : Departement affected ");
	}
	
	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
		List<String> depNames = new ArrayList<>();
		logger.info("In getAllDepartementsNamesByEntreprise method");
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		logger.info("Out getAllDepartementsNamesByEntreprise method");
		return depNames;
	}

	@Transactional
	@Override
	public void deleteEntrepriseById(int entrepriseId) {
		try{
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
		logger.info("Entreprise deleted successfully");}
		catch (Exception e) {
			logger.error("Error in deleteEntrepriseById : " + e );
		}
	}

	@Transactional
	@Override
	public void deleteDepartementById(int depId) {
		deptRepoistory.delete(deptRepoistory.findById(depId).orElse(null));	
		logger.info("Departement deleted successfully");
	}

	@Override
	public Entreprise getEntrepriseById(int entrepriseId) {
		try{
		logger.info("getEntrepriseById method");
		 entrepriseRepoistory.findById(entrepriseId).orElse(null);	}
		catch (Exception e) {
			logger.error("Error in getEntrepriseById : " + e );
		}
		
		return entrepriseRepoistory.findById(entrepriseId).orElse(null);	
	}

}
