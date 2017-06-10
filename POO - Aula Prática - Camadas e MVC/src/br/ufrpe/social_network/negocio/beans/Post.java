package br.ufrpe.social_network.negocio.beans;

import java.util.ArrayList;

public class Post {
    
    private long id;
    private String texto;
    private Person author;
    private ArrayList<Post> comments;

    public Post(String texto, Person author) {
        // TODO Implementar a mesma estratégia da classe Person para geração de ID  
        
        this.texto = texto;
        this.author = author;
        this.comments = new ArrayList<>();
    }
    
    public Post() {
        this(null, null);
    }

    // TODO gerar todos os métodos get/set, exceto o setId
    
    public String getTexto() {
    	
    	return this.texto;
    }
    
    public void setTexto(String novoTexto) {
    	
    	this.texto = novoTexto;
    }
    
    public Person getAuthor() {
    	
    	return this.author;
    }
    
    public void setAuthor(Person author) {
    	
    	this.author = author;
    }
    
    public long getId() {
    	
    	return this.id;
    }
    
    public void addComment(Post comment) {
        if (comment != null) {
            this.comments.add(comment);
        }
    }
    
    public void removeComment(Long id) {
        // TODO remover comentário da lista de comentários se ele existir. 
        // Você deve varrer a lista inteira verificando se há algum 
        // comentário com o ID informado como parâmetro e então removê-lo
    	
    	
    	for(int i = 0 ; i < this.comments.size(); i++) {
    		
    		if(this.comments.get(i).getId() == id) {
    			
    			this.comments.remove(i);
    		}
    		
    	}
    }
    
    @Override
    public String toString() {
        // TODO Implementar método toString da classe Person
    	return String.format("%s\n%s", this.author.toString(), this.texto);
    }
}
