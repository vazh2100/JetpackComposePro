package vazh2100.vk_client.domain.usecases

import com.vk.id.VKID

object GetToken {
    operator fun invoke() = VKID.instance.accessToken?.token ?: error("")
}