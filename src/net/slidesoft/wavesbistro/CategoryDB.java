package net.slidesoft.wavesbistro;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import static net.slidesoft.wavesbistro.Utils.CAT_DB;

public class CategoryDB extends ArrayList<Category> implements Serializable {

    private CatListModel model ;
    
    private static final CategoryDB catDb = new CategoryDB();
    
    private CategoryDB() {
    }
    
    public void addCat(Category c){
        if ( this.contains(c) ) {
            Utils.error( "Category allready exists, please choose another Name", null);
            return ;
        }
        this.add(c);
        model.add(c);
        save();
    }
    
    public static CategoryDB get(){
        return catDb;
    }

    void loadData( CatListModel mo ) {
        model = mo ;
        
        File catDB = new File(CAT_DB);
        if ( catDB.exists()  ) {
            System.out.println("Load From Cat DB from Disk");
            loadDataFromFile();
            return ;
        }
        
        Category plats = new Category( "Plats");
        plats.add( new Product(1, "Tajin Poulet", 10, 35.0) );
        plats.add( new Product(2, "Pates Nature", 10, 35.0) );
        plats.add( new Product(3, "Tajine Poisson", 10, 35.0) );
        plats.add( new Product(4, "Tajin Chevre", 10, 35.0) );
        plats.add( new Product(5, "Pates Vegetarien", 10, 35.0) );
        plats.add( new Product(6, "Tajine Doukali", 10, 35.0) );
        this.add(plats);
        
        Category salades = new Category( "Salades");
        this.add( salades );
 
        Category boisson = new Category( "Boissons");
        this.add( boisson );
        
        Category desserts = new Category( "Deserts");
        this.add( desserts );
        
        save(  );
 
        this.forEach( c -> mo.add( c ) );
        
        
    }

    private void save() {
        Utils.saveCatDB(this);
    }

    private void loadDataFromFile(  ) {
        CategoryDB cdb = Utils.loadCatDB();
        cdb.forEach( c -> model.add(c) );
    }
    
    
}
