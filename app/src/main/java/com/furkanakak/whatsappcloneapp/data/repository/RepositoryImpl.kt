package com.furkanakak.whatsappcloneapp.data.repository
import com.furkanakak.whatsappcloneapp.data.remote.ApiService
import com.furkanakak.whatsappcloneapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private var apiService: ApiService) : Repository {
    override suspend fun getChatData() = apiService.getChatData()


}