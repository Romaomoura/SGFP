package com.romoura.sgfp.domain

import com.romoura.sgfp.domain.enums.TipoConta
import jakarta.persistence.*
import java.math.BigInteger
import java.time.LocalDateTime
import java.util.*

@Entity(name = "contas")
data class Conta(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_gen")
    @SequenceGenerator(
        name = "seq_conta_gen", allocationSize = 1, initialValue = 1,
        sequenceName = "seq_conta"
    )
    val id: UUID? = null,

    @Column(updatable = false, nullable = false)
    var createdAt: LocalDateTime? = null,
    @Column(nullable = false)
    var updatedAt: LocalDateTime? = null,

    val name: String,
    val holder: String,
    val type: TipoConta,

    val expirationDay: Int? = null,
    val numberIdentification: BigInteger? = null

): AuditedEntity{

    @PrePersist
    override fun preSave() {
        createdAt = LocalDateTime.now()
        updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    override fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }

}
