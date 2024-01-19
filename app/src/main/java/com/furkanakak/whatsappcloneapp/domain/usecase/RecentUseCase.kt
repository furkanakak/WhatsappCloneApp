package com.furkanakak.whatsappcloneapp.domain.usecase

import com.furkanakak.whatsappcloneapp.common.Resource
import com.furkanakak.whatsappcloneapp.data.entity.ChatResponse
import com.furkanakak.whatsappcloneapp.domain.repository.Repository
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class RecentUseCase @Inject constructor(private val repository : Repository) {
    operator fun invoke(): Flow<Resource<ChatResponse>> = flow {
        try {
            emit(Resource.Loading)
            emit(Resource.Success(repository.getChatData()))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage.orEmpty()))
        }
    }

}