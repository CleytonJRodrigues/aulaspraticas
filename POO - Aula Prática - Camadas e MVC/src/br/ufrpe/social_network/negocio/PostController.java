package br.ufrpe.social_network.negocio;

import br.ufrpe.social_network.dao.PostDAO;
import br.ufrpe.social_network.negocio.beans.Post;

public class PostController {
    
    private PostDAO postsRepository;
    private static PostController instance;
    
    // DONE implementar corpo dos métodos CRUD deste controlador
    
    public void savePost(Post p) {
    	
    	this.postsRepository.save(p);
    }
    
    public Post findPost(long postId) {
       return this.postsRepository.find(postId);
    }
    
    public void updatePost(Post newPost) {
    	this.postsRepository.update(newPost);
    }
    
    public void deletePost(Post p) {
    	
    	this.postsRepository.delete(p);
    } 
    
    
    // DONE Implementar singleton para este controlador
    
    private PostController() {
    	
    	this.postsRepository = PostDAO.getInstance();
    }
    
    public static PostController getInstance() {
    	
    	if(instance == null) {
    		instance = new PostController();
    	}
    	return instance;
    }    
   
    // DONE Implementar método que lista todos os posts de uma determinada pessoa
    public String listPosts(long personId) {
    
    	return this.postsRepository.listPosts(personId);
    }
    
    // TODO DESAFIO Implementar método que busque todos comentários que uma dada pessoa realizou em posts de terceiros
    // Para implementar este método, você deve fazer uma buscar em todos os 
    // comentários de todos os posts, verificando quem realizou aqueele comentário.
    // Lembre-se que é possível realizar comentários de comentários e busca 
    // precisaria ser feita em profundidade
}
