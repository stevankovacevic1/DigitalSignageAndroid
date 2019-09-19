package com.consulteer.digital_signage

import android.app.Application
import com.consulteer.digital_signage.data.db.AppDatabase
import com.consulteer.digital_signage.data.network.MyApi
import com.consulteer.digital_signage.data.network.NetworkConnectionInterceptor
import com.consulteer.digital_signage.data.preferences.PreferenceProvider
import com.consulteer.digital_signage.data.repositories.EventsRepository
import com.consulteer.digital_signage.data.repositories.GroupRepository
import com.consulteer.digital_signage.data.repositories.UserRepository
import com.consulteer.digital_signage.view.ui.auth.AuthViewModelFactory
import com.consulteer.digital_signage.view.ui.home.employees.UsersViewModelFactory
import com.consulteer.digital_signage.view.ui.home.events.EventsViewModelFactory
import com.consulteer.digital_signage.view.ui.home.profile.ProfileViewModelFactory
import com.consulteer.digital_signage.view.ui.home.profile.editProfile.EditProfileViewModelFactory
import com.consulteer.digital_signage.view.ui.home.vacationReq.VacCalendarViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import kotlin.math.sign

class MVVMDigitalSignage : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMDigitalSignage))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from singleton { EventsRepository(instance(), instance(),instance() ) }
        bind() from singleton { GroupRepository(instance(),instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { EventsViewModelFactory(instance()) }
        bind() from provider {UsersViewModelFactory(instance())}
        bind() from provider {VacCalendarViewModelFactory(instance())}
        bind () from provider{EditProfileViewModelFactory(instance())}



    }
}