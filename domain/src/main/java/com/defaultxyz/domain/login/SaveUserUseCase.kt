package com.defaultxyz.domain.login

import com.defaultxyz.domain.base.Param1UseCase

interface SaveUserUseCase : Param1UseCase<Pair<String, String>, Unit>
