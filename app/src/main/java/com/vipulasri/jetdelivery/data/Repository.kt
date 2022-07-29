package com.vipulasri.jetdelivery.data

import com.vipulasri.jetdelivery.network.NetworkClient
import com.vipulasri.jetdelivery.network.model.Dashboard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object Repository {

    private val apiService = NetworkClient.service

    suspend fun getDashboardData(randomCalls: RandomCalls = RandomCalls.ONE): Result<List<Dashboard.Item>> {
        return withContext(Dispatchers.IO) {
            try {
                when (randomCalls) {
                    RandomCalls.ONE -> Result.Success(apiService.getRandomOneDashboard().data)
                    RandomCalls.TWO -> Result.Success(apiService.getRandomTwoDashboard().data)
                    RandomCalls.THREE -> Result.Success(apiService.getRandomThreeDashboard().data)
                    RandomCalls.FOUR -> Result.Success(apiService.getRandomFourDashboard().data)
                }
            } catch (exception: Exception) {
                Result.Failure(exception)
            }
        }
    }

    enum class RandomCalls {
        ONE,
        TWO,
        THREE,
        FOUR
    }
}
