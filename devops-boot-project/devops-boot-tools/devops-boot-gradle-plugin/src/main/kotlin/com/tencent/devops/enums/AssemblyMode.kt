package com.tencent.devops.enums

enum class AssemblyMode {
    CONSUL,
    K8S,
    KUBERNETES,
    OTHER;

    companion object {
        fun ofValueOrDefault(value: String): AssemblyMode {
            val upperCase = value.toUpperCase()
            return values().find { it.name == upperCase } ?: OTHER
        }
    }
}
