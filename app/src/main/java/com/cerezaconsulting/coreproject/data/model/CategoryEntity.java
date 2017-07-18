package com.cerezaconsulting.coreproject.data.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by junior on 23/06/17.
 */

public class CategoryEntity implements Serializable {

    private String id;
    private String image;
    private String name;


    public CategoryEntity(String id, String image, String name){
        this.id = id;
        this.image = image;
        this.name = name;
    }


    public static ArrayList<CategoryEntity> categoryEntities(){
        ArrayList<CategoryEntity> categoryEntities =  new ArrayList<>();

        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Diversion"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Comida"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Salud"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Educación"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Belleza"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Vivienda"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Servicios"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Deudas"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Manutencion"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Hijos"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Ropa"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Familia"));
        categoryEntities.add(new CategoryEntity("1","http://cdn.koreaboo.com/wp-content/uploads/2016/12/nayeon-6.jpg","Movilidad"));

        return categoryEntities;


    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
