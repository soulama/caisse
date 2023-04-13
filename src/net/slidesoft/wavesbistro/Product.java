package net.slidesoft.wavesbistro;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Rachid El Alaoui , SlideSoft.net
 */
class Product implements Comparable<Product>, Cloneable, Serializable {
    int id ;
    String name ;
    int qtn ;
    int stock ;
    Double price ;

    @Override
    public String toString() {
        return name ;
    }

    public Product(int id, String name, int stock, Double price) {
        this.id = id;
        this.name = name;
        this.qtn = 1;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtn() {
        return qtn;
    }

    public String getQtnAsString() {
        return String.valueOf( qtn );
    }

    public void setQtn(int qtn) {
        this.qtn = qtn;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPriceWithQtn() {
        return price * qtn ;
    }

    public String getPriceAsString() {
        return String.valueOf( price );
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare( this.getId(), o.getId());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.name.toLowerCase());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }

    void incByOne() {
        ++this.qtn ;
    }

    void decrementByOne() {
        --this.qtn ;
    }
    
    public String getCSVLine(){
        return ""+id+"; "+name+"; "+qtn+"; "+price ;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
    
    
    
    
    
}
