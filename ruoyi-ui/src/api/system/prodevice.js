import request from '@/utils/request'

// 查询工艺设备数据列表
export function listProdevice(query) {
  return request({
    url: '/system/prodevice/list',
    method: 'get',
    params: query
  })
}

// 查询工艺设备数据详细
export function getProdevice(manageProdevId) {
  return request({
    url: '/system/prodevice/' + manageProdevId,
    method: 'get'
  })
}

// 新增工艺设备数据
export function addProdevice(data) {
  return request({
    url: '/system/prodevice',
    method: 'post',
    data: data
  })
}

// 修改工艺设备数据
export function updateProdevice(data) {
  return request({
    url: '/system/prodevice',
    method: 'put',
    data: data
  })
}

// 删除工艺设备数据
export function delProdevice(manageProdevId) {
  return request({
    url: '/system/prodevice/' + manageProdevId,
    method: 'delete'
  })
}

// 导出工艺设备数据
export function exportProdevice(query) {
  return request({
    url: '/system/prodevice/export',
    method: 'get',
    params: query
  })
}