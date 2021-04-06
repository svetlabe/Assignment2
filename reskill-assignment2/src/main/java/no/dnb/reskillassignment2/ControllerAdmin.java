package no.dnb.reskillassignment2;

import no.dnb.reskillassignment2.datalayer.AdministratorRepository;
import no.dnb.reskillassignment2.datalayer.ConfigurationDataRepository;
import no.dnb.reskillassignment2.datalayer.EnvironmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;


@RestController
    @RequestMapping("/XXXX")  // TODO: 06.04.2021 change XXXX to actual path for website (ex. /destinations)
    @CrossOrigin

    public class ControllerAdmin {

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    ConfigurationDataRepository configurationDataRepository;

    @Autowired
    EnvironmentsRepository environmentsRepository;


    //get one product
    @GetMapping(value = "/XXXX/{id}", produces = {"application/json"})
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product p =  service.findInStock(id);
        if (p==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok().body(p);
        }
    }


    //get all products
    @GetMapping(value = "/XXXX", produces = {"application/json"})  //, "application/xml"
    public ResponseEntity<Collection<Product>> getAllProducts(){
        Collection<Product> products = service.getAllProducts();

        return ResponseEntity.ok().body(products);
    }


    //update product
    @PutMapping(value= "/XXXX/{id}", consumes={"application/json","application/xml"})
    public ResponseEntity<Void> updateProduct(@PathVariable int id, @RequestBody Product product) {
        if (!service.updateStock(product))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }


    //create
    @PostMapping(
            value= "/XXXX",
            consumes={"application/json"},  //,"application/x-www-form-urlencoded"},
            produces={"application/json"})
    public void addProductToStock(@RequestBody Product product) {
        System.out.println(product);
        service.addToStock(product);
        URI uri = URI.create("/products/" + product.getId());
        // return ResponseEntity.created(uri).body(product);
    }


    @DeleteMapping("/XXXX/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        if (!service.deleteFromStock(id))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }


}
