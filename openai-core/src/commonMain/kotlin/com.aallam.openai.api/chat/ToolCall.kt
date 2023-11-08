package com.aallam.openai.api.chat

import com.aallam.openai.api.OpenAIDsl
import com.aallam.openai.api.chat.internal.ToolType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The tool call generated by the model, such as function call.
 *
 * In case of streaming variant of the chat API, the object parameters can be `null`.
 */
@Serializable
public data class ToolCall(
    /** The ID of the tool call. **/
    @SerialName("id") val idOrNull: ToolId? = null,
    /** The type of the tool. **/
    @SerialName("type") val typeOrNull: ToolType? = null,
    /** The function that the model called. **/
    @SerialName("function") val functionOrNull: FunctionCall? = null,
) {

    /** The ID of the tool call. **/
    val id: ToolId
        get() = requireNotNull(idOrNull)

    /** The type of the tool. **/
    val type: ToolType
        get() = requireNotNull(typeOrNull)

    /** The function that the model called. **/
    val function: FunctionCall
        get() = requireNotNull(functionOrNull)
}

/**
 * The tool call generated by the model, such as function call.
 */
public fun toolCall(block: ToolCallBuilder.() -> Unit): ToolCall = ToolCallBuilder().apply(block).build()

@OpenAIDsl
public class ToolCallBuilder {
    /** The ID of the tool call. **/
    public var id: ToolId? = null

    /** The type of the tool. **/
    public var type: ToolType? = null

    /** The function that the model called. **/
    public var function: FunctionCall? = null

    /**
     * Create [ToolCall] instance.
     */
    public fun build(): ToolCall = ToolCall(
        idOrNull = id,
        typeOrNull = type,
        functionOrNull = function,
    )
}