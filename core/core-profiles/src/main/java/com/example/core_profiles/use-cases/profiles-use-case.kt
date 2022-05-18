import com.example.core_profiles.models.Item
import com.example.core_profiles.models.ProfilesModel

typealias GetAllProfilesUseCase = @JvmSuppressWildcards UseCase<QueryRequest, @JvmSuppressWildcards List<Item>>

data class QueryRequest(
    val query: String,
    val page: Int
)