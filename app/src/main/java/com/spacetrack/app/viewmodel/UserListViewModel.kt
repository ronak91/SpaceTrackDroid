package com.spacetrack.app.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import com.spacetrack.app.viewmodel.data.UsersList
import timber.log.Timber
import java.util.concurrent.TimeUnit

class UserListViewModel(private val userRepository: UserRepository) : ViewModel(){

    fun getUsers(): Observable<UsersList> {
        //Create the data for your UI, the users lists and maybe some additional data needed as well
        return userRepository.getUsers()
                .map {
                    Timber.d("Mapping users to UIData...")
                    UsersList(it.take(10), "Top 10 Users")
                }
                .onErrorReturn {
                    Timber.d("An error occurred $it")
                    UsersList(emptyList(), "An error occurred", it)
                }
    }
}
