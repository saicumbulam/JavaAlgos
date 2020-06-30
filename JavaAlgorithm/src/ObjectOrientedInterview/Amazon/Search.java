package ObjectOrientedInterview.Amazon;

import java.util.HashMap;
import java.util.List;

class Catalog implements Search {
    HashMap<String, List<Product>> productNames;
    HashMap<String, List<Product>> productCategories;

    public List<Product> searchProductsByName(String name) {
        return productNames.get(name);
    }

    public List<Product> searchProductsByCategory(String category) {
        return productCategories.get(category);
    }
}

public interface Search {
    public List<Product> searchProductsByName(String name);
    public List<Product> searchProductsByCategory(String category);
}

