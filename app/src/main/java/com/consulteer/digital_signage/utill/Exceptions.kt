package com.consulteer.digital_signage.utill

import java.io.IOException

class ApiExpection(message:String) : IOException(message)
class NoInternetException (message: String): IOException(message)