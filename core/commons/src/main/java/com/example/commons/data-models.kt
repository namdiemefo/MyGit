import com.example.commons.ApplicationError
import kotlinx.coroutines.flow.Flow

data class MyResult<out T>(
    val error: ApplicationError = ApplicationError.NoError,
    val data: T? = null
) {
    companion object {
        fun <T> data(
            data: T
        ): MyResult<T> {
            return MyResult(
                data = data
            )
        }

        fun <T> error(
            error: ApplicationError
        ): MyResult<T> {
            return MyResult(
                error = error,
            )
        }
    }
}

sealed class SimpleResultState {
    object Success: SimpleResultState()
    data class Error(val error: ApplicationError): SimpleResultState()
}

sealed class DomainResult<T> {
    data class Success<T>(val data: T) : DomainResult<T>()
    data class Error<T>(val error: ApplicationError) : DomainResult<T>()
}

interface UseCase<in P, T>  {
    suspend operator fun invoke(page: P): Flow<DomainResult<T>>
}