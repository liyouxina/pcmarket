import request from "@/utils/request";
import {parseStrEmpty} from "@/utils/ruoyi";

export function listGoods(query) {
  return request({
    url: '/market/goods/list',
    method: 'get',
    params: query
  })
}

export function updateGoods(data) {
  return request({
    url: '/market/goods',
    method: 'put',
    data: data
  })
}

export function delGoods(ids) {
  return request({
    url: '/market/goods/' + ids,
    method: 'delete'
  })
}

export function addGoods(data) {
  return request({
    url: '/market/goods',
    method: 'post',
    data: data
  })
}

export function getGoods(id) {
  return request({
    url: '/market/goods/' + parseStrEmpty(id),
    method: 'get'
  })
}
