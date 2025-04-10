/**
 * 주문등록
 * @param payload
 * @returns {Promise<*>}
 */
function addOrder(payload) {
  return $.ajax({
    url        : '/api/order',
    type       : 'POST',
    contentType: "application/json",
    data       : JSON.stringify(payload)
  });
};

/**
 * 주문정보 조회
 * @param orderCode
 * @returns {Promise<*>}
 */
async function getOrderDetails(orderCode) {
  return await $.ajax({
    url : '/api/order?orderCode=' + orderCode,
    type: 'GET'
  });
};
