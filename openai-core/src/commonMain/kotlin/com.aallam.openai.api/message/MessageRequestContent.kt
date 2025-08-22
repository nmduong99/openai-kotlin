package com.aallam.openai.api.message

import com.aallam.openai.api.BetaOpenAI
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The content of the message as text or image.
 */
@BetaOpenAI
@Serializable
public sealed interface MessageRequestContent {

    /**
     * The content of the message as text.
     */
    @BetaOpenAI
    @Serializable
    @SerialName("text")
    public data class Text(
        /**
         * The text content of the message value and annotations.
         */
        @SerialName("text") val text: String
    ) : MessageRequestContent

    /**
     * References an image File in the content of a message.
     */
    @BetaOpenAI
    @Serializable
    @SerialName("image_file")
    public data class Image(
        /**
         * The File ID of the image in the message content.
         */
        @SerialName("image_file") val imageFile: ImageFile
    ) : MessageRequestContent

}
