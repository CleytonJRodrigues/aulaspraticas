package br.ufrpe.social_network.negocio;

import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class Fachada {
    
    // DONE Implementar Fachada que usa métodos do controlador de pessoas e posts
    // Todos os métodos devem ser do tipo delegate e podem ser gerados 
    // automaticamente pelo Eclipse se não houver conflito de nomes
	
	private PersonController persons;
	private PostController posts;
	
	private static Fachada instance;
	
	private Fachada() {
		
		this.persons = PersonController.getInstance();
		this.posts = PostController.getInstance();
	}
    
    // DONE implementar singleton
    
	public void savePerson(Person p) {
		persons.savePerson(p);
	}

	public Person findPerson(long personId) {
		return persons.findPerson(personId);
	}

	public void updatePerson(Person newPerson) {
		persons.updatePerson(newPerson);
	}

	public void deletePerson(Person p) {
		persons.deletePerson(p);
	}

	public void savePost(Post p) {
		posts.savePost(p);
	}

	public Post findPost(long postId) {
		return posts.findPost(postId);
	}

	public void updatePost(Post newPost) {
		posts.updatePost(newPost);
	}

	public void deletePost(Post p) {
		posts.deletePost(p);
	}

	public String listPosts(long personId) {
		return posts.listPosts(personId);
	}

	public static Fachada getInstance() {
		if(instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
}
