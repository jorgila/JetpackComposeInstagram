package com.estholon.jetpackcomposeinstagram.login.domain

import com.estholon.jetpackcomposeinstagram.login.data.LoginRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository){

    suspend operator fun invoke(user: String, password: String): Boolean{
        return repository.doLogin(user,password)
    }

}