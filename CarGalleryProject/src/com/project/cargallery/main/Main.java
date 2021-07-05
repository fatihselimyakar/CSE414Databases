package com.project.cargallery.main;

import java.util.List;
import com.project.cargallery.db.CarGalleryDbMethods;
import com.project.cargallery.models.*;

public class Main {
	
	static <T> void printEntries(List<T> a) {
	    for (T o : a) {
	    	System.out.println(o.toString());
	    }
	}
	
    public static void main(String[] args) {        
        CarGalleryDbMethods<Car> carTable = new CarGalleryDbMethods<Car>(new Car());
        printEntries(carTable.getAllIntances());
        System.out.println();
        
        CarGalleryDbMethods<GenericView> view = new CarGalleryDbMethods<GenericView>(new GenericView("[Cars with Motor,Tyre and Equipment View]"));
        System.out.print(view.getAllIntancesForViews());
            
    }
 

}
