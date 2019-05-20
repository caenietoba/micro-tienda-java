package sa.product.service;

import sa.product.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProductService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Product> getAllProducts(int first, int maxResult) {
        return entityManager.createNamedQuery(Product.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Product getProductByCode(long code){
        return entityManager.find(Product.class, code);
    }

    public void createProduct(Product product) {
        entityManager.persist(product);
    }

    public Product updateProduct(long code, Product product) {
        Product productToUpdate = entityManager.find(Product.class, code);
        productToUpdate.setName(product.getName());
        productToUpdate.setQuantity(product.getQuantity());
        productToUpdate.setCost(product.getCost());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setStoreId(product.getStoreId());
        return entityManager.merge(productToUpdate);
    }

    public void deleteProduct(long code) {
        Product product = entityManager.find(Product.class, code);
        entityManager.remove(product);
    }
}
