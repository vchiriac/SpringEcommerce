package org.ecommerce.services;

import org.ecommerce.exception.WebException;
import org.ecommerce.model.Category;
import org.ecommerce.model.Product;
import org.ecommerce.repository.CategoryRepository;
import org.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CatalogService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getByName(name);
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findOne(id);
    }

    public Category createCategory(Category category) {
        Category persistedCategory = getCategoryByName(category.getName());
        if (persistedCategory != null) {
            throw new WebException("Category " + category.getName() + " already exist");
        }
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        Category persistedCategory = getCategoryById(category.getId());
        if (persistedCategory == null) {
            throw new WebException("Category " + category.getId() + " doesn't exist");
        }
        persistedCategory.setDescription(category.getDescription());
        persistedCategory.setDisplayOrder(category.getDisplayOrder());
        persistedCategory.setDisabled(category.isDisabled());
        return categoryRepository.save(persistedCategory);
    }

    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    public Product getProductBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    public Product createProduct(Product product) {
        Product persistedProduct = getProductBySku(product.getName());
        if (persistedProduct != null) {
            throw new WebException("Product SKU " + product.getSku() + " already exist");
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        Product persistedProduct = getProductById(product.getId());
        if (persistedProduct == null) {
            throw new WebException("Product " + product.getId() + " doesn't exist");
        }
        persistedProduct.setDescription(product.getDescription());
        persistedProduct.setDisabled(product.isDisabled());
        persistedProduct.setPrice(product.getPrice());
        persistedProduct.setCategory(getCategoryById(product.getCategory().getId()));
        return productRepository.save(persistedProduct);
    }

    public List<Product> searchProducts(String query) {
        return productRepository.search("%" + query + "%");
    }
}