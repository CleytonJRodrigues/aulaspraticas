package br.ufrpe.social_network.gui;

import java.time.LocalDate;

import br.ufrpe.social_network.negocio.Fachada;
import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class TextualUserInterface {
    
    public void showUserInterface() {
        // TODO implementar código que usa a Fachada. Detalhamento:
        
        /*
        
        1.  Crie quatro pessoas e salve-as
        2.  Apague uma das pessoas
        3.  Atualize o nome de uma das pessoas
        4.  Busque por um objeto do tipo pessoa que tenha um ID qualquer.
        5.  Crie 15 posts aleatórios, 5 para cada uma das pessoas criadas anteriormente
        6.  Crie 2 comentários de resposta de uma das pessoas em cada um dos posts de outra pessoa
        7.  Liste todos os posts de todas as pessoas
        8.  (DESAFIO) Liste somente os comentários que cada uma das pessoas fez em outros posts de outras pessoas

        */
    	
    	Fachada fachada = Fachada.getInstance();
    	
    	Person a = new Person("Mary-ann", "USA", LocalDate.of(1996, 05, 16));
    	Person b = new Person("Carlos", "BRA", LocalDate.of(1996, 05, 16));
    	Person c = new Person("González", "ESP", LocalDate.of(1996, 05, 16));
    	Person d = new Person("Lara", "MAL", LocalDate.of(1996, 05, 16));
    	
    	fachada.savePerson(a);
    	fachada.savePerson(b);
    	fachada.savePerson(c);
    	fachada.savePerson(d);
    	
    	fachada.deletePerson(b);
    	
    	d.setName("Lára");
    	fachada.updatePerson(d);
    	
    	fachada.findPerson(3);
    	
    	//Mary
    	Post a1 = new Post("Hi", a);
    	Post a2 = new Post("Im ok", a);
    	
    	// todo não completo...
    }

}
