package GeoMylonas.SpringFramework.spring5webapp.bootstrap;

import GeoMylonas.SpringFramework.spring5webapp.model.Author;
import GeoMylonas.SpringFramework.spring5webapp.model.Book;
import GeoMylonas.SpringFramework.spring5webapp.model.Publisher;
import GeoMylonas.SpringFramework.spring5webapp.model.repositories.AuthorRepository;
import GeoMylonas.SpringFramework.spring5webapp.model.repositories.BookRepository;
import GeoMylonas.SpringFramework.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        //Harper Collins
        Publisher harper=new Publisher("Harper Collins");
        publisherRepository.save(harper);
        //Eric
        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Drivern Design","1234");
        ddd.setPublisher(harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);





        //Worx
        Publisher worx=new Publisher("worx");
        publisherRepository.save(worx);
        //Rod
        Author rod=new Author("Rod","Johnson");
        Book noEJB=new Book("J2EE Development Without EJB","23444");
        noEJB.setPublisher(worx);
        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
