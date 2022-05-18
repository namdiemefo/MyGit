import com.example.core_profiles.models.Item
import javax.inject.Inject

class ProfileMapperImpl
@Inject
constructor(

) : ProfilesMapper {
    override fun mapToDto(domain: Item): ItemResponse {
        return ItemResponse(
            avatar_url = domain.avatar_url,
            id = domain.id,
            type = domain.type,
            events_url = "",
            followers_url = "",
            following_url = "",
            gists_url = "",
            gravatar_id = "",
            html_url = "",
            login = "",
            node_id = "",
            organizations_url = "",
            received_events_url = "",
            repos_url = "",
            score = 0.0,
            site_admin = true,
            starred_url = "",
            subscriptions_url = "",
            url = ""
        )
    }

    override fun mapToDomain(model: ItemResponse): Item {
        return Item(
            avatar_url = model.avatar_url,
            id = model.id,
            type = model.type
        )
    }


}