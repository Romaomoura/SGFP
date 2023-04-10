package com.romoura.sgfp.domain

import java.io.Serializable

interface AuditedEntity : Serializable {

    fun preSave()

    fun preUpdate()

}