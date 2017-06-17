package br.ufrpe.social_network.dao;

import java.time.LocalDate;

import br.ufrpe.social_network.negocio.beans.Person;

public class PersonDAO {
    
    //DONE implementar singleton para esta classe - PersonDAO
	
	private static PersonDAO instance;
	
	public static PersonDAO getInstance() {
		
		if(instance == null) {
			instance = new PersonDAO();
		}
		return instance;
	}
    
    //DONE Implementar CRUD para classe básica Person usando array
    /*
     * Antes de implementar os métodos, pense bem na assinatura dos mesmos
     */
	
	private Person[] persons;
	private static int proximo = 0;
	
    private PersonDAO() {
    	
    	persons = new Person[100];
    }
    
    public void create(String name, String country, LocalDate birthdate) {
    	
    	Person p = new Person(name, country, birthdate);
    	this.save(p);
    }
    
    public void save(Person p) {
	
    	this.persons[proximo] = p;
    	proximo++;
    	if(proximo == this.persons.length){
    		
    		this.duplicaVetor();
    	}
    }
    
    private void duplicaVetor() {
    	
    	int tam = persons.length * 2;
    	
    	Person[] peeps = new Person[tam];
    	
    	for(int i = 0; i < this.persons.length; i++) {
    		
    		peeps[i] = this.persons[i];
    	}
    	
    	this.persons = peeps;    	
    }
    
    public Person find(Long id) {
    	
    	int found = this.findI(id);
    	
    	return this.persons[found];
    }
    
    private int findI(Long id) {
    	
    	int found = -1;
    	
    	for(int i = 0; i < this.persons.length; i++) {
    		
    		if(this.persons[i].getId() == id) {
    			found = i;
    		}
    	}
    	
    	return found;
    }
    
    public void update(Person newPerson) {
    	
    	int i = findI(newPerson.getId() );
    	
    	this.persons[i] = newPerson;
    }
    
    public void delete(Person p) {
    	
    	int i = findI(p.getId() );
    	
    	persons[i] = null;
    	persons[i] = persons[persons.length - 1];
    	persons[persons.length-1] = null;
    }
    
}
