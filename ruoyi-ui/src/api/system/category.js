import request from "@/utils/request";
import {parseStrEmpty} from "@/utils/ruoyi";

export function listCategory(query) {
  return request({
    url: '/market/category/list',
    method: 'get',
    params: query
  })
}

export function updateCategory(data) {
  return request({
    url: '/market/category',
    method: 'put',
    data: data
  })
}

export function delCategory(id) {
  return request({
    url: '/market/category/' + id,
    method: 'delete'
  })
}

export function addCategory(data) {
  return request({
    url: '/market/category',
    method: 'post',
    data: data
  })
}

export function getCategory(id) {
  return request({
    url: '/market/category/' + parseStrEmpty(id),
    method: 'get'
  })
}
