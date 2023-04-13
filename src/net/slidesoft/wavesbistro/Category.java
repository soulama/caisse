package net.slidesoft.wavesbistro;

import java.util.Objects;
import java.util.TreeSet;

public final class Category extends TreeSet<Product> {
        private String name ;
        private int id ;

    public Category(String name ) {
        this.name = name;
        this.id = name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( this.name.toLowerCase() );
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
        final Category other = (Category) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name ;
    }
        
        
}
