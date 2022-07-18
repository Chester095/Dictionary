package com.geekbrains.dictionary.di

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
// @Module помечает класс с набором методов, которые отмечаются аннотациями @Provides
class DependencyModule {
    @Provides
    // @Provides указывает на метод, который предоставляет (возвращает) зависимость для
    //дальнейшего внедрения.
    fun dependency(): IDependency {
        return ExampleDependency()
    }
}

@Component(modules = [DependencyModule::class])
// @Component отмечает интерфейс, который позже используется для генерации кода. В нём
// определяется, куда что-либо внедрять, а также методы для прямого доступа к зависимостям.
interface AppComponent2 {
    fun inject(exampleInstance: ExampleClass2)
}

class ExampleClass2() {
    @Inject
    lateinit var dependency: IDependency
    fun doSomethingWithDependency() {
        dependency.doSomething()
    }
}


class ExampleClass() {
    private val dependency: ExampleDependency = ExampleDependency()
    fun doSomethingWithDependency() {
        dependency.doSomething()
    }
}

interface IDependency {
    fun doSomething()
}

class ExampleDependency : IDependency {
    override fun doSomething() {
        //...
    }
}
