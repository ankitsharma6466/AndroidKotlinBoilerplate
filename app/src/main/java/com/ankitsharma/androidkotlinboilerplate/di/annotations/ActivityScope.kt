package com.ankitsharma.androidkotlinboilerplate.di.annotations

import javax.inject.Scope

/**
 * Defines Application level scope, any field or method annotated with this will have only a single instance
 *
 * Created by ankitsharma on 16/01/18.
 */
@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope