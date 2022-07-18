package com.geekbrains.dictionary.di

import dagger.Component
import javax.inject.Singleton

@Singleton
// Singleton — это базовая аннотация, предоставляемая Dagger. Она предоставляется, чтобы было от
//чего отталкиваться. Появление Singletone не произойдёт магическим образом, если не сохранить свой
//AppComponent в классе App — классе, расширяющем Application.
@Component(modules = [NetworkModule::class, StorageModule::class])
// @Component отмечает интерфейс, который позже используется для генерации кода. В нём
// определяется, куда что-либо внедрять, а также методы для прямого доступа к зависимостям
interface AppComponent {
    // injest - внедрить
}