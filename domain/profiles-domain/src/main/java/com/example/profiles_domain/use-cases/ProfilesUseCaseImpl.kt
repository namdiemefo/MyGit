import com.example.core_profiles.domain.ProfilesRepository
import com.example.core_profiles.models.Item
import com.example.core_profiles.models.ProfilesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllProfilesUseCaseImpl
@Inject
constructor(
    private val repository: ProfilesRepository
) : GetAllProfilesUseCase {
    override suspend fun invoke(request: QueryRequest): Flow<DomainResult<List<Item>>> = flow {
        repository.getAllProfiles(query = request.query, page = request.page).collect {
            emit(it)
        }
    }
}