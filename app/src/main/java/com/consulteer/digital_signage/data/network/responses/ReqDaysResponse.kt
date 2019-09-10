package com.consulteer.digital_signage.data.network.responses

import com.consulteer.digital_signage.data.db.entities.VacReq
import java.time.LocalDate

data class ReqDaysResponse (
    var vacation: List<VacReq>,
    val existVacation: Boolean,
    val getVacation: VacReq



)