import request from '@/utils/request'

// 查询用户信息列表
export function listInfor(query) {
  return request({
    url: '/system/infor/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息详细
export function getInfor(companyId) {
  return request({
    url: '/system/infor/' + companyId,
    method: 'get'
  })
}

// 新增用户信息
export function addInfor(data) {
  return request({
    url: '/system/infor',
    method: 'post',
    data: data
  })
}

// 修改用户信息
export function updateInfor(data) {
  return request({
    url: '/system/infor',
    method: 'put',
    data: data
  })
}

// 删除用户信息
export function delInfor(companyId) {
  return request({
    url: '/system/infor/' + companyId,
    method: 'delete'
  })
}

// 导出用户信息
export function exportInfor(query) {
  return request({
    url: '/system/infor/export',
    method: 'get',
    params: query
  })
}