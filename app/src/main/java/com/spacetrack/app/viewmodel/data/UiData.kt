package com.spacetrack.app.viewmodel.data

import com.spacetrack.app.repository.data.User

data class UsersList(val users: List<User>, val message: String, val error: Throwable? = null)
