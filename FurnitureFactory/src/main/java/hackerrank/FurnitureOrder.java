Skip to content
Product 
Team
Enterprise
Explore 
Marketplace
Pricing 
Search
Sign in
Sign up
ironijunior
/
java-exercise
Public
Code
Issues
Pull requests
1
Actions
Projects
Wiki
Security
Insights
java-exercise/FurnitureFactory/src/main/java/hackerrank/FurnitureOrder.java /
@ironijunior
ironijunior add classes and projects of java exercises
Latest commit d195ff7 on Jan 25, 2019
 History
 1 contributor
63 lines (53 sloc)  1.61 KB

package hackerrank;

import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
    
	private final HashMap<Furniture, Integer> furnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnitures = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        Integer count = 0;
        if(furnitures.containsKey(type)) {
            count = furnitures.get(type);
        }
        furnitures.put(type, count + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<Furniture, Integer>(furnitures);
    }

    public float getTotalOrderCost() {
        if(!furnitures.isEmpty()) {
        	return furnitures.entrySet().stream()
        			.map(f -> f.getKey().cost() * f.getValue())
        			.collect(Collectors.toList())
        			.stream()
        			.reduce(Float::sum)
        			.get();
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        if(furnitures.containsKey(type)) {
        	return furnitures.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
    	if(furnitures.containsKey(type)) {
        	return furnitures.get(type) * type.cost();
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
    	if(!furnitures.isEmpty()) {
        	return furnitures.values().stream()
        			.reduce(Integer::sum)
        			.get();
        }
        return 0;
    }
}
