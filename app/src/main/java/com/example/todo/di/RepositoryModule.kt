package com.example.todo.di

import com.example.todo.data.repository.TodoRepositoryImpl
import com.example.todo.domain.repository.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTodDoRepository(repositoryImpl: TodoRepositoryImpl): TodoRepository
}
