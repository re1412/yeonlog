/**
 * 상품 목록 조회
 * @param pageModel
 * @returns {Promise<*>}
 */
async function getProducts(pageModel) {
  return await $.ajax({
    url : '/api/products',
    type: 'GET',
    data: pageModel
  });
};

/**
 * 상품 상세조회
 * @param id
 * @returns {Promise<*>}
 */
async function getProduct(id) {
  return await $.ajax({
    url : '/api/product/' + id,
    type: 'GET'
  });
};
