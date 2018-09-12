package be.bt.rest;

import be.bt.domain.Product;
import be.bt.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductRestController {

    @Autowired
    private IProductsRepository repo;

    @GetMapping("")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<Product> getAll() {
        return repo.findAll();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product p = repo.save(product);

        return (p != null)? new ResponseEntity<>(p ,HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
