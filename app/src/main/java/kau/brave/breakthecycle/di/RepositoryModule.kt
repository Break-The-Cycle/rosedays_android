package kau.brave.breakthecycle.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kau.brave.breakthecycle.data.database.AddressRepository
import kau.brave.breakthecycle.data.repository.AddressRepositoryImpl
import kau.brave.breakthecycle.data.repository.AuthRepositoryImpl
import kau.brave.breakthecycle.data.repository.MenstruationRepositoryImpl
import kau.brave.breakthecycle.data.repository.ViolentRecordRepositoryImpl
import kau.brave.breakthecycle.domain.repository.AuthRepository
import kau.brave.breakthecycle.domain.repository.MenstruationRepository
import kau.brave.breakthecycle.domain.repository.ViolentRecordRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @ViewModelScoped
    abstract fun bindCalendarRepository(
        menstruationRepositoryImpl: MenstruationRepositoryImpl
    ): MenstruationRepository

    @Binds
    @ViewModelScoped
    abstract fun bindViolentRecordRepository(
        violentRecordRepositoryImpl: ViolentRecordRepositoryImpl
    ): ViolentRecordRepository

    @Binds
    @ViewModelScoped
    abstract fun bindAddressRepository(
        addressRepositoryImpl: AddressRepositoryImpl
    ): AddressRepository
}