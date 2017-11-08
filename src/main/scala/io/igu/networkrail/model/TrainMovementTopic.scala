/*
 * Copyright (c) 2017 igu.io. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.igu.networkrail.model

sealed trait TrainMovementTopic {
  val topic: String
}

object TrainMovementTopic {

  object AllTrainOperatingCompanies extends TrainMovementTopic {
    val topic: String = "TRAIN_MVT_ALL_TOC"
  }

  object AllNonPassengerTrainOperatingCompanyMovements extends TrainMovementTopic {
    val topic: String = "TRAIN_MVT_FREIGHT"
  }

  object ChangeOfIdentityMessagesForFreightTrains extends TrainMovementTopic {
    val topic: String = "TRAIN_MVT_GENERAL"
  }

  def from(operatingCompany: TrainOperatingCompany): TrainMovementTopic = new TrainMovementTopic {
    override val topic: String = s"TRAIN_MVT_${operatingCompany.businessCode}_TOC"
  }
}