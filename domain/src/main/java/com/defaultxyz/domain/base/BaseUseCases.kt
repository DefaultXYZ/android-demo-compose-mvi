package com.defaultxyz.domain.base

interface Param0UseCase<T : Any> : suspend () -> T

interface Param1UseCase<P1 : Any, T : Any> : suspend (P1) -> T
