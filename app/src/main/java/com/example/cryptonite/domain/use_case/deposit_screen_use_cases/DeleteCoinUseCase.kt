package com.example.cryptonite.domain.use_case.deposit_screen_use_cases


import com.example.cryptonite.domain.repository.UserCoinRepository
import javax.inject.Inject

class DeleteCoinUseCase @Inject constructor(
    private val repository: UserCoinRepository
) {

    suspend operator fun invoke(id: String) {
        repository.deleteCoinById(id)
    }
    
}