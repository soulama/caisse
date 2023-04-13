package net.slidesoft.wavesbistro;

import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Rachid El Alaoui , SlideSoft.net
 */
public final class CatListModel<Category> extends DefaultListModel<Category>  {

    private final static CatListModel model = new CatListModel();

    private CatListModel() { 
    }
    
    public void add(Category c){
        this.addElement(c);
    }
    
    static CatListModel get() {
        return model ;
    }
    
    public List<Category> categories() {
        Category[] ar = (Category[]) this.toArray();
        return Arrays.asList( ar );
    }
    
}
