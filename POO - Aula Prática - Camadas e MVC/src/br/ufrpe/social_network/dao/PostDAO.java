package br.ufrpe.social_network.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import br.ufrpe.social_network.negocio.PersonController;
import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class PostDAO {
    
    //DONE implementar singleton para esta classe - PostDAO
	
	private static PostDAO instance;
		
		public static PostDAO getInstance() {
			
			if(instance == null) {
				instance = new PostDAO();
			}
			return instance;
		}
    
    //DONE Implementar CRUD para classe básica Post usando ArrayList

    /*
     * Antes de implementar os métodos, pense bem na assinatura dos mesmos
     */
		
		private ArrayList<Post> posts;
		
	    private PostDAO() {
	    	
	    	this.posts = new ArrayList<Post>();
	    }
	    
	    public void create(String text, Person author) {
	    	
	    	Post p = new Post(text, author);
	    	this.save(p);
	    }
	    
	    public void save(Post p) {
	    	
	    	if(p != null) {
	    		this.posts.add(p);
	    	}
	    }
	    
	    public Post find(Long id) {
	    	
	    	int found = this.findI(id);
	    	
	    	if(found == -1){
	    		return null;
	    	}
	    	
	    	else{
	    		return this.posts.get(found);
	    	}
	    }
	    
	    private int findI(Long id) {
	    	
	    	int found = -1;
	    	
	    	for(int i = 0; i < this.posts.size(); i++) {
	    		
	    		if(this.posts.get(i).getId() == id) {
	    			
	    			found = i;
	    		}
	    	}
	    	
	    	return found;
	    }
	    
	    public void update(Post newPost) {
	    	
	    	int i = findI(newPost.getId() );
	    	
	    	this.posts.remove(i);
	    	this.posts.add(newPost);
	    }
	    
	    public void delete(Post p) {
	    	
	    	this.posts.remove(p);
	    }
	    
	    public String listPosts(long personId) {
	    	
	    	PersonController person = PersonController.getInstance();
	    	String result = person.findPerson(personId).getName();
	    	
	    	int i = 0;
    	 	do{
	    		if(posts.get(i).getAuthor().getId() == personId) {
	    			result = result + "\n" + posts.get(i).getTexto() + "\n";
	    		}
	    		i++;
	    	}while(i < this.posts.size());
	    	
	    	return result;
	    }
	
}
