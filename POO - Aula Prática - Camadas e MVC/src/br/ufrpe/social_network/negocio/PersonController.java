package br.ufrpe.social_network.negocio;

import br.ufrpe.social_network.dao.PersonDAO;
import br.ufrpe.social_network.negocio.beans.Person;

public class PersonController {
    
    private PersonDAO personsRepository;
    private static PersonController instance;
    
    private PersonController() {
        // Construtor privado para implementação de singleton
    	this.personsRepository = PersonDAO.getInstance();
    }

    public static PersonController getInstance() {
        if (instance == null) {
            instance = new PersonController();
        }
        return instance;
    }
    
    public void savePerson(Person p) {
        // DONE Método que salva pessoa no repositório
    	this.personsRepository.save(p);
    }
    
    public Person findPerson(long personId) {
        // DONE Retorna o objeto do tipo Person que contenha aquele ID
       return personsRepository.find(personId);
    }
    
    public void updatePerson(Person newPerson) {
        //DONE Encontra no repositório obj que tenha id igual a newPerson.id e atualiza objeto 
    	this.personsRepository.update(newPerson);
    }
    
    public void deletePerson(Person p) {
        // DONE apaga do repositório objeto que contenha o id igual a p.id 
    	this.personsRepository.delete(p);
    }
}
