package com.yeon.product.service;

import com.yeon.product.domain.Product;
import com.yeon.product.domain.ProductEditor;
import com.yeon.product.model.request.ProductRequest;
import com.yeon.product.model.response.ProductResponse;
import com.yeon.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();

        ProductResponse response = ProductResponse.from(product);

        return response;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ProductResponse> getProductList(Pageable pageable) {
        return productRepository.findAll(pageable).map(ProductResponse::new);
    }

    @Transactional
    @Override
    public void registerProduct(ProductRequest productRequest) {
        Product product = Product.of(productRequest);

        productRepository.save(product);
    }

    @Transactional
    @Override
    public void updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.getReferenceById(id);

        ProductEditor.ProductEditorBuilder productEditorBuilder = product.toEditor();

        ProductEditor productEditor = productEditorBuilder
                .name(productRequest.getName())
                .summary(productRequest.getSummary())
                .price(productRequest.getPrice())
                .content(productRequest.getContent())
                .build();

        product.edit(productEditor);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow();

        productRepository.delete(product);
    }
}



