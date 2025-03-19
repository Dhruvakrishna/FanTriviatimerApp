package com.example.fantriviatimerapp


import com.example.fantriviatimerapp.data.TicketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTicketRepository(): TicketRepository {
        return TicketRepository()
    }
}