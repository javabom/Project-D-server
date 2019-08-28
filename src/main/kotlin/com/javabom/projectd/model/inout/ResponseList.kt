package com.javabom.projectd.model.inout

data class ResponseList<T>(val pagination: Pagination, val data: List<T>)
