package com.subratgyawali.boilerplatemvp.exceptions

import java.io.IOException

class FailedResponseException(override val message: String) : IOException(message)

class NetworkNotAvailableException : IOException("No Internet Connection")
