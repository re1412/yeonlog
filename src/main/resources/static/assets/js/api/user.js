/**
 * 로그인
 * @returns {Promise<*>}
 */
export async function login() {
  return await $.ajax({
    url : '/api/login',
    type: 'GET'
  });
};

/**
 * 로그인 유저정보 조회
 * @returns {Promise<*>}
 */
export async function getUser() {
  return await $.ajax({
    url : '/api/customer',
    type: 'GET'
  });
};


