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

package io.igu.networkrail.model.schedule

import io.igu.networkrail.cif.model.RecordType

/**
  * Created by jackliddiard on 31/03/17.
  */
case class OriginLocation(location: String,
                          scheduledDeparture: String,
                          publicDeparture: String,
                          platform: String,
                          line: String,
                          engineeringAllowance: String,
                          pathingAllowance: String,
                          activity: String,
                          performanceAllowance: String,
                          reservedfield: String,
                          spare: String) extends ScheduleRecord(RecordType.ORIGIN_LOCATION)
