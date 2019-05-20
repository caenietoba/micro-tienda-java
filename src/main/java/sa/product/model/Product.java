package sa.product.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NamedQueries({@NamedQuery(name = Product.FIND_ALL, query = "SELECT u FROM Product u")})
public class Product {

    public static final String FIND_ALL = "Product.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private Long quantity;
    private Double cost;
    private Long storeId;
    private String description;

    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }

    public String getDescription(){
      return description;
    }
    public void setDescription(String description){
      this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
}